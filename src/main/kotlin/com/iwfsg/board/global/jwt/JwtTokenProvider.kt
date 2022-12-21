package com.iwfsg.board.global.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*


@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val userDetailsService: UserDetailsService,
    ) {

    companion object{
        const val ACCESS_TYPE = "access"
        const val REFRESH_TYPE = "refresh"
        const val ACCESS_EXP = 60L * 15 // 15 min
        const val REFRESH_EXP = 60L * 60 * 24 * 7 // 1 weeks
        const val TOKEN_PREFIX = "Bearer "
    }
    fun createToken(userId: String,type: String, secret: String,exp: Long): String {
        val claims: Claims = Jwts.claims().setSubject(userId)
        claims["userId"] = userId
        return Jwts.builder()
            .signWith(getSigningKey(secret),SignatureAlgorithm.HS256)
            .setHeaderParam("typ", "JWT")
            .setClaims(claims)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .compact()
    }
    fun getUserPk(token: String) : String {
        return Jwts.parserBuilder().setSigningKey(jwtProperties.accessSecret).build().parseClaimsJws(token).body.subject

    }
    fun getAuthentication(token: String?): Authentication {
        val userDetails = userDetailsService.loadUserByUsername(())
    }
    fun generateAccessToken(userId: String): String =
        createToken(userId, ACCESS_TYPE, jwtProperties.accessSecret, ACCESS_EXP)



    private fun getSigningKey(secret: String): Key{
        val byteArray = secret.toByteArray()
        return Keys.hmacShaKeyFor(byteArray)
    }
}
