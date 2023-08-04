package com.example.oopplayground.model.discounts.policy

import com.example.oopplayground.model.Money
import com.example.oopplayground.model.Screening
import com.example.oopplayground.model.discounts.DiscountCondition

class AmountDiscountPolicy(
    discountAmount: Money,
    vararg conditions: DiscountCondition,
) : DiscountPolicy(*conditions) {

    private val discountAmount: Money = discountAmount
    override fun getDiscountAmount(screening: Screening): Money = discountAmount
}
