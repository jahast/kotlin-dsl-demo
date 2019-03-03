package com.example.demo.classes

enum class PetType {CAT, DOG, OTHER}

enum class Color {BROWN, WHITE, BLACK, OTHER}

enum class Decision {YES, NO, MAYBE}

enum class Flag{GREEN, AMBER, RED}

data class Pet(val petType: PetType, val weight: Double, val color: Color)

data class Customer(val pets: Collection<Pet>, val priorityCustomer: Boolean)

data class Request(val customer: Customer)

data class Response(val decision: Decision, val evaluatedRules: Collection<RuleEvaluation>, val discount: Double)

data class RuleEvaluation(val id: String, val flag: Flag)

data class EvaluatedRuleSet(val decision: Decision, val evaluatedRules: Collection<RuleEvaluation>)

