package com.drawhunt.app.presentation.controller

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/")
    fun returnTestMessage(authentication: Authentication): String {
        val username = authentication.name
        return "Hello World! This is a test response from the server. Welcome to Drawhunt, $username!"
    }
}