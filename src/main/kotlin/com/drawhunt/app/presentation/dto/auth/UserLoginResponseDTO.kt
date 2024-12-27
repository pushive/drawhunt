package com.drawhunt.app.presentation.dto.auth

import jakarta.validation.constraints.NotBlank

data class UserLoginResponseDTO(
    @field: NotBlank
    val token: String
)