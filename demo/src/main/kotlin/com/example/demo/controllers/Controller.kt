package com.example.demo.controllers

import com.example.demo.classes.Request
import com.example.demo.classes.Response
import com.example.demo.services.getDiscount
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class DiscountController {
    @PostMapping("/api/v1/discount")
    fun discount(@RequestBody request: Request): Response {
        return getDiscount(customer = request.customer)
    }
}
