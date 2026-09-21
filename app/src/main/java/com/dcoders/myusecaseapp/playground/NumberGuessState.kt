package com.dcoders.myusecaseapp.playground

data class NumberGuessState(
    val numberText: String="",
    val guessText: String?=null,
    val isGuessCorrect:Boolean=false
)
