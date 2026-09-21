package com.dcoders.myusecaseapp.playground

import android.service.credentials.Action
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random


class NumberGuessViewModel(): ViewModel() {


    private var guessNumber= Random.nextInt(0,100)
    private val _state= MutableStateFlow(NumberGuessState())
    val state=_state.asStateFlow()

    fun onAction(action: NumberGuessAction){
        when(action) {
            NumberGuessAction.onNumberGuessClick -> {

                    val guess=state.value.numberText.toIntOrNull()
                    _state.update { it.copy(
                        guessText = when{
                            guess==null->"Please enter a value"
                            guess > guessNumber->"value is larger"
                            guess < guessNumber->"value is smaller"
                            else->"you guessed correct text"
                        }
                    , isGuessCorrect=guessNumber==guess,
                        numberText = "")}

            }
            is NumberGuessAction.onNumberTextChanged -> {
                _state.update { it.copy(
                    action.numberText
                ) }
            }
            NumberGuessAction.onStartNewButton -> {
                guessNumber= kotlin.random.Random.nextInt(1,100)
                _state.update {it.copy(
                    numberText = "",
                    isGuessCorrect = false,
                    guessText = null
                )
                }
            }
        }

    }
}