package com.example.demo.eligiblity

import com.example.demo.classes.Color
import com.example.demo.classes.Customer
import com.example.demo.classes.Flag
import com.example.demo.classes.PetType

private val AMBER = Flag.AMBER
private val RED = Flag.RED

internal fun ruleSet(): RuleSet {
    return rules {
        rule {
            id = "EXCESSIVE_NUMBER_OF_DOGS"
            violationFlag = AMBER
            condition =
                { c: Customer -> c.pets.count { it.petType == PetType.DOG } > 2 }
        }
        rule {
            id = "NO_WHITE_PETS"
            violationFlag = RED
            condition =
                { c: Customer -> c.pets.any { it.color == Color.WHITE }.not() }
        }
    }
}
