package com.dcoders.myapplicationtest.state_management

sealed interface NumberGuessAction {

    data object onGuessClick: NumberGuessAction
    data class onNumberTextChange(val numberText: String): NumberGuessAction
    data object onStartNewGameButton: NumberGuessAction


}