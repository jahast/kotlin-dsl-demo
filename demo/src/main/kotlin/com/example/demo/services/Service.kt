package com.example.demo.services

import com.example.demo.classes.Customer
import com.example.demo.classes.Decision
import com.example.demo.classes.Response
import com.example.demo.discount.calculateDiscount
import com.example.demo.eligiblity.evaluateRules

fun getDiscount(customer: Customer): Response {

    val evaluatedRuleSet = evaluateRules(customer)

    val discount = if (evaluatedRuleSet.decision == Decision.NO) 0.0 else calculateDiscount(customer)

    return Response(evaluatedRuleSet.decision, evaluatedRuleSet.evaluatedRules, discount)
}
