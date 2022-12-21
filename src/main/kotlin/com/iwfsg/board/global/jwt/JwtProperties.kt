package com.iwfsg.board.global.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties ("jwt")
class JwtProperties (
    val accessSecret: String,
    val refreshSecret: String
)