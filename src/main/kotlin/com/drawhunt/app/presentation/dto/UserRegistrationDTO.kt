package com.drawhunt.app.presentation.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UserRegistrationDTO(
    @field:NotBlank(message = "User Name is required")
    @field:Size(min = 3, max = 50, message = "User Name must be between 3 and 50 characters")
    val username: String,

    @field:NotBlank(message = "Password is required")
    @field:Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
    val password: String,

    @field:NotBlank(message = "Email address is required")
    @field:Email(message = "Please enter a valid email address")
    val emailAddress: String
)