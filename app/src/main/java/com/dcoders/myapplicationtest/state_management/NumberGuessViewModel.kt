package com.dcoders.myapplicationtest.state_management

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Random

class NumberGuessViewModel() : ViewModel() {
    var guessText = kotlin.random.Random.nextInt(1, 100)
    var maxAttempt = 0

    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()

    fun onAction(action: NumberGuessAction) {
        when (action) {
            NumberGuessAction.onGuessClick -> {
                val guess = state.value.numberText.toInt()
                if (guess != null) {
                    maxAttempt++
                }
                _state.update {
                    it.copy(
                        guessText = when {
                            guess == null -> "Please enter a number"
                            guess < guessText -> "My number is large"
                            guess > guessText -> "My number is small"
                            else -> "You got it in $maxAttempt attempts"
                        },
                        numberText = "",
                        isGuessCorrect = guess == guessText

                    )
                }

            }

            is NumberGuessAction.onNumberTextChange -> {
                _state.update { value ->
                    value.copy(
                        numberText = action.numberText
                    )
                }
            }

            NumberGuessAction.onStartNewGameButton -> {
                guessText = kotlin.random.Random.nextInt(1, 100)
                _state.update {
                    it.copy(
                        guessText = null,
                        numberText = "",
                        isGuessCorrect = false
                    )
                }
                maxAttempt = 0
            }
        }
    }


}