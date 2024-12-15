package com.drawhunt.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DrawhuntApplication

fun main(args: Array<String>) {
    runApplication<DrawhuntApplication>(*args)
}
