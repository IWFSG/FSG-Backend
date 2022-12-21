package com.iwfsg.board.global.security.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


class CustomUserDetails(private var user: com.iwfsg.board.domain.user.entity.User) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? = null

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.username

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}