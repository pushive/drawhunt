package com.drawhunt.app.usecase

import com.drawhunt.app.domain.model.User
import com.drawhunt.app.domain.repository.UserRepository
import com.drawhunt.app.presentation.dto.auth.UserLoginRequestDTO
import com.drawhunt.app.presentation.dto.auth.UserRegistrationDTO
import com.drawhunt.app.security.JwtUtil
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val mailSender: JavaMailSender,
    private val authenticationManager: AuthenticationManager,
    private val jwtUtil: JwtUtil
) {

    @Transactional
    fun registerNewUser(userDTO: UserRegistrationDTO): Unit {
        if (userRepository.findByUsername(userDTO.username) != null) {
            throw IllegalArgumentException("The user name is already in use")
        }

        if (userRepository.findByEmailAddress(userDTO.emailAddress) != null) {
            throw IllegalArgumentException("The email address is already in use")
        }

        val pwd = passwordEncoder.encode(userDTO.password)
        val confirmationToken = UUID.randomUUID().toString()
        val newUser = User(
            username = userDTO.username,
            password = pwd,
            emailAddress = userDTO.emailAddress,
            confirmationToken = confirmationToken
        )
        userRepository.save(newUser)
        sendConfirmationEmail(userDTO.emailAddress, confirmationToken)
    }

    @Transactional
    fun loginUser(userDTO: UserLoginRequestDTO): String {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(userDTO.username, userDTO.password)
        )
        val principal = authentication.principal as org.springframework.security.core.userdetails.User
        val jwt = jwtUtil.generateToken(principal.username)
        return jwt
    }

    @Transactional
    fun confirmNewUser(token: String): Unit {
        val user = userRepository.findByConfirmationToken(token)
            ?: throw IllegalArgumentException("Invalid token")

        if (user.isConfirmed) {
            throw IllegalArgumentException("This token has already been confirmed")
        }

        user.isConfirmed = true
        userRepository.save(user)
    }

    private fun sendConfirmationEmail(emailAddress: String, confirmationToken: String): Unit {
        val message = SimpleMailMessage().apply {
            setTo(emailAddress)
            subject = "Confirmation Email"
            text = """
                Thank you for registering.
                Please click the link below to confirm your account:
                http://localhost:8030/user/confirm?token=$confirmationToken
            """.trimIndent()
        }
        mailSender.send(message)
    }
}