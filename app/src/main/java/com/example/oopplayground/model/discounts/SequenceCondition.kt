package com.example.oopplayground.model.discounts

import com.example.oopplayground.model.Screening

class SequenceCondition(
    sequence: Int,
) : DiscountCondition {

    private val sequence: Int = sequence
    override fun isSatisfiedBy(screening: Screening): Boolean = screening.isSequence(sequence)
}
