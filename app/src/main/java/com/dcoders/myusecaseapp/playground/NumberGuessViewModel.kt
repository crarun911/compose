package com.dcoders.myusecaseapp.playground

import android.service.credentials.Action
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NumberGuessViewModel(): ViewModel() {


    private val _state= MutableStateFlow(NumberGuessState())
    val state=_state.asStateFlow()

    fun onAction(action: NumberGuessAction){
        when(action) {
            NumberGuessAction.onNumberGuessClick -> {}
            is NumberGuessAction.onNumberTextChanged -> {
                _state.update { it.copy(
                    action.numberText
                ) }
            }
            NumberGuessAction.onStartNewButton -> {
                _state.update {it.copy(
                    numberText = ""
                )
                }
            }
        }

    }
}