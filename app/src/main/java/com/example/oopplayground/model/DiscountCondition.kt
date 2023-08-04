package com.example.oopplayground.model

interface DiscountCondition {

    fun isSatisfiedBy(screening: Screening): Boolean
}
