package com.dcoders.myapplicationtest.state_management

data class NumberGuessState(
    val numberText: String = "",
    val guessText: String?= "",
    val isGuessCorrect: Boolean = false
)
