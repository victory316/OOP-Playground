package com.example.oopplayground.model.discounts

import com.example.oopplayground.model.Money
import com.example.oopplayground.model.Screening

class AmountDiscountPolicy(
    discountAmount: Money,
    vararg conditions: DiscountCondition,
) : DiscountPolicy(*conditions) {

    private val discountAmount: Money = discountAmount
    override fun getDiscountAmount(screening: Screening): Money = discountAmount
}
