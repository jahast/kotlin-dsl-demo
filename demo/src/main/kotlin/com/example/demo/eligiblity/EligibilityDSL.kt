package com.example.demo.eligiblity

import com.example.demo.classes.*

internal typealias CustomerCondition = (Customer) -> Boolean

internal class RuleSet {
    var rules = mutableListOf<Rule>()

    fun rule(init: RuleBuilder.() -> Unit) {
        val builder = RuleBuilder()
        builder.apply(init)
        rules.add(builder.build())
    }

    fun evaluate(customer: Customer): EvaluatedRuleSet {
        val evaluatedRules = rules.map { it.evaluate(customer) }
        val decision = aggregateRulesToDecision(evaluatedRules)
        return EvaluatedRuleSet(decision, evaluatedRules)

    }

    private fun aggregateRulesToDecision(evaluatedRules: Collection<RuleEvaluation>): Decision {
        return when {
            evaluatedRules.any { it.flag == Flag.RED } -> Decision.NO
            evaluatedRules.any { it.flag == Flag.AMBER } -> Decision.MAYBE
            else -> Decision.YES
        }
    }
}

internal class Rule(private val id: String, private val violationFlag: Flag, private val condition: CustomerCondition) {
    fun evaluate(customer: Customer): RuleEvaluation {
        val evaluation = condition(customer)
        return if (evaluation) RuleEvaluation(id, violationFlag) else RuleEvaluation(id, Flag.GREEN)
    }
}

internal class RuleBuilder {
    lateinit var id: String
    lateinit var violationFlag: Flag
    lateinit var condition: CustomerCondition

    fun build() = Rule(id, violationFlag, condition)
}

internal fun rules(init: RuleSet.() -> Unit): RuleSet {
    val rules = RuleSet()
    rules.init()
    return rules
}

