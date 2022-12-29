package com.iwfsg.board.global.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.security.Key
import java.time.ZonedDateTime
import java.util.*


@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
) {
    companion object{
        private const val ACCESS_TYPE = "access"
        private const val REFRESH_TYPE = "refresh"
        private const val ACCESS_EXP: Long = 60*15
        private const val REFRESH_EXP: Long = 60*60*24*7
    }
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

}
