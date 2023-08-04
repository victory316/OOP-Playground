package com.example.oopplayground.model

import java.math.BigDecimal

abstract class DiscountPolicy(
    vararg conditions: DiscountCondition,
) {

    private val conditions: List<DiscountCondition> = conditions.asList()

    fun calculateDiscountAmount(screening: Screening): Money {
        conditions.forEach { each ->
            if (each.isSatisfiedBy(screening)) return getDiscountAmount(screening)
        }

        return Money(BigDecimal.ZERO)
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}
