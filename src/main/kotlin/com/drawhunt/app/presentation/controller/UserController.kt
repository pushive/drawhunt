package com.drawhunt.app.presentation.controller

import com.drawhunt.app.presentation.dto.auth.UserLoginRequestDTO
import com.drawhunt.app.presentation.dto.auth.UserLoginResponseDTO
import com.drawhunt.app.presentation.dto.auth.UserRegistrationDTO
import com.drawhunt.app.usecase.AuthService
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val authService: AuthService,
) {
    @PostMapping("/create")
    fun registerUser(
        @Valid @RequestBody userDTO: UserRegistrationDTO,
        bindingResult: BindingResult
    ): ResponseEntity<Any> {
        if (bindingResult.hasErrors()) {
            val errors = bindingResult.fieldErrors.associate { it.field to it.defaultMessage }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapOf("error" to errors))
        }

        return try {
            authService.registerNewUser(userDTO)
            ResponseEntity.status(HttpStatus.CREATED).body(mapOf("message" to "User created successfully"))
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapOf("error" to e.message))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapOf("error" to "Server error"))
        }
    }

    @PostMapping("/login")
    fun loginUser(
        @Valid @RequestBody userDTO: UserLoginRequestDTO,
        @Valid
        bindingResult: BindingResult
    ): ResponseEntity<Any> {
        if (bindingResult.hasErrors()) {
            val errors = bindingResult.fieldErrors.associate { it.field to it.defaultMessage }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapOf("error" to errors))
        }

        return try {
            val jwt = authService.loginUser(userDTO)
            ResponseEntity.status(HttpStatus.OK).body(UserLoginResponseDTO(token = jwt))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapOf("error" to e.message))
        }
    }


    @GetMapping("/confirm")
    fun confirmNewUser(
        @RequestParam @NotBlank token: String
    ): ResponseEntity<Any> {
        return try {
            authService.confirmNewUser(token)
            ResponseEntity.status(HttpStatus.ACCEPTED).body(mapOf("message" to "User confirmed successfully"))
        } catch (e: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapOf("error" to e.message))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapOf("error" to "Server error"))
        }
    }

}