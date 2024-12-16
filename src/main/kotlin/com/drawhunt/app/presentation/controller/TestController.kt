package com.drawhunt.app.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @GetMapping("/")
    fun returnTestMessage(): String {
        return "Hello World! This is a test response from the server."
    }
}