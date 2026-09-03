package com.dcoders.myusecaseapp.playground

sealed interface NumberGuessAction {
    data object onNumberGuessClick: NumberGuessAction
    data class  onNumberTextChanged(val numberText:String): NumberGuessAction
    data object onStartNewButton: NumberGuessAction
}