package com.example.oopplayground.model.discounts.policy

import com.example.oopplayground.model.Money
import com.example.oopplayground.model.Screening

class ZeroDiscountPolicy : DiscountPolicy() {

    override fun getDiscountAmount(screening: Screening): Money {
        return Money.wons(0)
    }
}
