package com.drawhunt.app.presentation.dto.auth

import jakarta.validation.constraints.NotBlank

data class UserLoginRequestDTO(
    @field:NotBlank(message = "User Name is required")
    val username: String,

    @field:NotBlank(message = "Password is required")
    val password: String,
)