package com.example.oopplayground.model

import java.time.LocalDateTime

class Screening(
    movie: Movie,
    sequence: Int,
    whenScreened: LocalDateTime,
) {

    private val movie: Movie = movie
    private val sequence: Int = sequence
    private val whenScreened = whenScreened

    fun getStartTime(): LocalDateTime = whenScreened

    fun isSequence(sequence: Int) = this.sequence == sequence

    fun getMovieFee(): Money = movie.getFee()
}
