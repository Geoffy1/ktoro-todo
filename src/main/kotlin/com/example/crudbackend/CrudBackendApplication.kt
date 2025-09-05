package com.example.crudbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrudBackendApplication

fun main(args: Array<String>) {
	runApplication<CrudBackendApplication>(*args)
}
