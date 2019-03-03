package com.example.demo.eligiblity

import com.example.demo.classes.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class EligibilityKtTest {

    @Test
    fun `yes decision for a good customer`() {
        val dummyCustomer = Customer(
            pets = listOf(Pet(PetType.DOG,5.0, Color.WHITE )),
            priorityCustomer = false
        )

        val evaluation = evaluateRules(dummyCustomer)

        assertEquals(evaluation.decision, Decision.YES)
        assertTrue { evaluation.evaluatedRules.all { it.flag == Flag.GREEN } }
    }

    @Test
    fun `maybe decision for too many dogs`() {
        val dummyCustomer = Customer(
            pets = listOf(
                Pet(PetType.DOG,5.0, Color.WHITE ),
                Pet(PetType.DOG,2.0, Color.OTHER ),
                Pet(PetType.DOG,7.0, Color.BLACK )
            ),
            priorityCustomer = false
        )

        val evaluation = evaluateRules(dummyCustomer)

        assertEquals(evaluation.decision, Decision.MAYBE)
        assertEquals(evaluation.evaluatedRules.single { it.id == "EXCESSIVE_NUMBER_OF_DOGS" }.flag, Flag.AMBER)
    }
}
