package com.example.demo.discount

import com.example.demo.classes.Customer

fun calculateDiscount(customer: Customer): Double {
    return if (customer.priorityCustomer) 0.1 else 0.0
}
