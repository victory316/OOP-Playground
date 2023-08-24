package com.example.oopplayground.model

import com.example.oopplayground.model.discounts.policy.DiscountPolicy
import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private var discountPolicy: DiscountPolicy
) {

    fun getFee(): Money = fee

    fun calculateMovieFee(screening: Screening): Money {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }

    fun changeDiscountPolicy(policy: DiscountPolicy) {
        discountPolicy = policy
    }
}
