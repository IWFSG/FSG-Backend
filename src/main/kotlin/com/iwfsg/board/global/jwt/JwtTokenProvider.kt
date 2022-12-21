package com.iwfsg.board.global.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwt
import io.jsonwebtoken.Jwts
import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.Date
import java.util.Locale
import javax.persistence.Id

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
            .setHeaderParam("typ", "JWT")
            .setClaims(claims)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .compact()
    }

}
