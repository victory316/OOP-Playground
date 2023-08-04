package com.example.oopplayground.model

import java.math.BigDecimal

class Money(
    amount: BigDecimal,
) {

    private val amount: BigDecimal = amount
    fun wons(amount: Long): Money {
        return Money(BigDecimal.valueOf(amount))
    }

    fun plus(amount: Money): Money {
        return Money(this.amount.add(amount.amount))
    }

    fun minus(amount: Money): Money {
        return Money(this.amount.subtract(amount.amount))
    }

    fun times(percent: Double): Money {
        return Money(this.amount.multiply(BigDecimal.valueOf(percent)))
    }

    fun isLessThan(other: Money): Boolean {
        return amount < other.amount
    }

    fun isGreaterThanOrEqual(other: Money): Boolean {
        return amount >= other.amount
    }
}
