package com.bmarques.springkotlinweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinwebApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinwebApplication>(*args)
}
