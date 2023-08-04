package com.example.oopplayground.model.discounts.policy

import com.example.oopplayground.model.Money
import com.example.oopplayground.model.Screening
import com.example.oopplayground.model.discounts.DiscountCondition

class PercentDiscountPolicy(
    percent: Double,
    vararg conditions: DiscountCondition,
) : DiscountPolicy(*conditions) {

    private val percent: Double = percent
    override fun getDiscountAmount(screening: Screening): Money {
        return screening.getMovieFee().times(percent)
    }
}
