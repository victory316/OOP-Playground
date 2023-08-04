package com.example.oopplayground.model.discounts

import com.example.oopplayground.model.Money
import com.example.oopplayground.model.Screening

class PercentDiscountPolicy(
    percent: Double,
    vararg conditions: DiscountCondition,
) : DiscountPolicy(*conditions) {

    private val percent: Double = percent
    override fun getDiscountAmount(screening: Screening): Money {
        return screening.getMovieFee().times(percent)
    }
}
