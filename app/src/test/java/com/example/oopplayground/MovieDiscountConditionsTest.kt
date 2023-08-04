package com.example.oopplayground

import com.example.oopplayground.model.Money
import com.example.oopplayground.model.Movie
import com.example.oopplayground.model.Screening
import com.example.oopplayground.model.discounts.AmountDiscountPolicy
import com.example.oopplayground.model.discounts.PeriodCondition
import com.example.oopplayground.model.discounts.SequenceCondition
import org.junit.Test
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

class MovieDiscountConditionsTest {
    @Test
    fun `Movie fee discounted with conditions`() {
        val policy = AmountDiscountPolicy(
            discountAmount = Money.wons(800),
            SequenceCondition(1),
            SequenceCondition(10),
            PeriodCondition(
                DayOfWeek.MONDAY,
                LocalTime.of(10, 0),
                LocalTime.of(11, 59),
            ),
            PeriodCondition(
                DayOfWeek.FRIDAY,
                LocalTime.of(0, 0),
                LocalTime.of(11, 59),
            ),
        )

        val avatar = Movie(
            title = "아바타",
            runningTime = Duration.ofMinutes(120),
            fee = Money.wons(10000),
            discountPolicy = policy,
        )

        val screeningTime = LocalDateTime.of(
            2023,
            8,
            15,
            10,
            0,
        )

        val screening = Screening(
            movie = avatar,
            sequence = 1,
            whenScreened = screeningTime,
        )

        assert(screening.calculateFee(1).amount.toInt() == 9200)
    }

    @Test
    fun `Movie fee not discounted with conditions`() {
        val policy = AmountDiscountPolicy(
            discountAmount = Money.wons(800),
            SequenceCondition(1),
            SequenceCondition(10),
            PeriodCondition(
                DayOfWeek.MONDAY,
                LocalTime.of(10, 0),
                LocalTime.of(11, 59),
            ),
            PeriodCondition(
                DayOfWeek.FRIDAY,
                LocalTime.of(0, 0),
                LocalTime.of(11, 59),
            ),
        )

        val avatar = Movie(
            title = "아바타",
            runningTime = Duration.ofMinutes(120),
            fee = Money.wons(10000),
            discountPolicy = policy,
        )

        val screeningTime = LocalDateTime.of(
            2023,
            8,
            13,
            10,
            0,
        )

        val screening = Screening(
            movie = avatar,
            sequence = 2,
            whenScreened = screeningTime,
        )

        assert(screening.calculateFee(1).amount.toInt() != 9200)
    }
}
