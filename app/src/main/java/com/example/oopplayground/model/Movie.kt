package com.example.oopplayground.model

import java.time.Duration

class Movie(
    title: String,
    runningTime: Duration,
    fee: Money,
    discountPolicy: DiscountPolicy,
) {

    private val title: String = title
    private val runningTime: Duration = runningTime
    private val fee: Money = fee
    private val discountPolicy: DiscountPolicy = discountPolicy

    fun getFee(): Money = fee

    fun calculateMovieFee(screening: Screening): Money {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }
}
