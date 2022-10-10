package com.bmarques.springresilience4japia

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class SpringResilience4jApiAApplication

fun main(args: Array<String>) {
	runApplication<SpringResilience4jApiAApplication>(*args)
}
