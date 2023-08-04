package com.example.oopplayground.model

import java.math.BigDecimal

abstract class DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money {
        return Money(BigDecimal.ZERO)
    }
}
