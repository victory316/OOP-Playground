package com.example.oopplayground.model.discounts

import com.example.oopplayground.model.Screening

interface DiscountCondition {

    fun isSatisfiedBy(screening: Screening): Boolean
}
