package com.example.oopplayground.model.discounts

import com.example.oopplayground.model.Screening
import java.time.DayOfWeek
import java.time.LocalTime

class PeriodCondition(
    dayOfWeek: DayOfWeek,
    startTime: LocalTime,
    endTime: LocalTime,
) : DiscountCondition {

    private val dayOfWeek: DayOfWeek = dayOfWeek
    private val startTime: LocalTime = startTime
    private val endTime: LocalTime = endTime
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.getStartTime().dayOfWeek.equals(dayOfWeek) &&
            startTime <= screening.getStartTime().toLocalTime() &&
            endTime >= screening.getStartTime().toLocalTime()
    }
}
