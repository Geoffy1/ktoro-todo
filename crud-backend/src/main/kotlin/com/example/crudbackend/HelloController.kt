
package com.example.crudbackend

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/api")
class HelloController {
    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World from Kotlin + Spring Boot 🚀"
    }
}