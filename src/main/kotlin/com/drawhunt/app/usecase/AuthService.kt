package com.drawhunt.app.usecase

import com.drawhunt.app.domain.model.User
import com.drawhunt.app.domain.repository.UserRepository
import com.drawhunt.app.presentation.dto.UserRegistrationDTO
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passowrdEncoder: PasswordEncoder
) {
    @Transactional
    fun registerNewUser(userDTO: UserRegistrationDTO): User {
        if (userRepository.findByUsername(userDTO.username).isPresent) {
            throw IllegalArgumentException("The user name is already in use")
        }
        if (userRepository.findByEmailAddress(userDTO.emailAddress).isPresent) {
            throw IllegalArgumentException("The email address is already in use")
        }
        val pwd = passowrdEncoder.encode(userDTO.password)
        val confirmationToken = UUID.randomUUID().toString()
        val newUser = User(
            username = userDTO.username,
            password = pwd,
            emailAddress = userDTO.emailAddress,
            confirmationToken = confirmationToken
        )
        return userRepository.save(newUser)
    }

    private fun sendConfirmationEmail(emailAddress: String) {
        
    }
}