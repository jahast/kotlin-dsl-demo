package com.example.demo

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean

@SpringBootConfiguration
class JacksonObjectMapperConfiguration {

    @Bean
    fun objectMapper() = KotlinModule()
}
