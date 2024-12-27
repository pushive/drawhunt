package com.drawhunt.app.security

import com.drawhunt.app.domain.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("No account found with that user name")

        return org.springframework.security.core.userdetails.User
            .builder()
            .username(user.username)
            .password(user.password)
            .authorities(if (user.isConfirmed) "CONFIRMED" else "NOT_CONFIRMED")
            .build()
    }
}