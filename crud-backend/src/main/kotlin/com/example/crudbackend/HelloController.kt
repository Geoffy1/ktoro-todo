package com.example.crudbackend

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    GetMapping("/hello")
    fun sayhello(): string {
        return "hello kotlin and springboot 🚀" 
    }
}