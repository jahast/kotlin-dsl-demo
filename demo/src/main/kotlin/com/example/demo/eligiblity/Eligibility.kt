package com.example.demo.eligiblity

import com.example.demo.classes.Customer
import com.example.demo.classes.EvaluatedRuleSet

fun evaluateRules(customer: Customer): EvaluatedRuleSet {
    return ruleSet().evaluate(customer)
}
