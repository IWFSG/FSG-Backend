package com.iwfsg.board.global.jwt

import com.iwfsg.board.global.security.exception.InvalidTokenException
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.hibernate.validator.internal.engine.messageinterpolation.parser.Token
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.security.Key
import java.security.SignatureException
import java.time.ZonedDateTime
import java.util.*
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest


@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val userDetailsService: UserDetailsService
) {
    companion object{
        private const val ACCESS_TYPE = "access"
        private const val REFRESH_TYPE = "refresh"
        private const val ACCESS_EXP: Long = 60*15
        private const val REFRESH_EXP: Long = 60*60*24*7
    }
    //token 생성
    private fun generateToken(userId: String, type: String, secret: String, exp: Long): String {
        return Jwts.builder()
            .signWith(getSigningKey(secret),SignatureAlgorithm.HS256)
            .claim("userId",userId)
            .claim("type",type)
            .setIssuedAt(Date())
            .setSubject(userId)
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .compact()
    }
    //signkey생성
    private fun getSigningKey(secret: String): Key? {
        val byteArray = secret.toByteArray()
        return Keys.hmacShaKeyFor(byteArray)
    }
    private fun generateAccessToken(userId: String): String =
        generateToken(userId, ACCESS_TYPE, jwtProperties.accessSecret, ACCESS_EXP)

    private fun generateRefreshToken(userId: String): String =
        generateToken(userId, REFRESH_TYPE, jwtProperties.refreshSecret, REFRESH_EXP)

    private fun getExpiredTime(): ZonedDateTime = ZonedDateTime.now().plusSeconds(ACCESS_EXP)

    fun getRefreshTokenExp():Long = REFRESH_EXP

    fun getAuthentication(token: String): Authentication {
        val userDetails = userDetailsService.loadUserByUsername(getTokenSubject(token, jwtProperties.accessSecret))
        return UsernamePasswordAuthenticationToken(userDetails,"",userDetails.authorities)
    }
    private fun getTokenSubject(token: String, secret: String): String {
        return getTokenBody(token, secret).get("userId", String::class.java)
    }

    private fun getTokenBody(token: String, secret: String): Any {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey(secret))
                .build()
                .parseClaimsJws(token)
                .body
        } catch (e: ExpiredJwtException) {
            throw ExpiredJwtException()
        } catch (e: MalformedJwtException) {
            throw InvalidTokenException()
        }catch (e: SignatureException) {
            throw InvalidTokenException()
        }
    }
    private fun getSignKey(secret: String): Key{
        val byteArray = secret.toByteArray()
        return Keys.hmacShaKeyFor(byteArray)
    }
    private fun resolveToken(request: HttpServletRequest): String? {
        val token = request.getHeader("Authorization")
        return if (token != null && token.startsWith("Bearer ")) token.replace("Bearer ", "") else null
    }

}
