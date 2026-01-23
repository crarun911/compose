package com.dcoders.myapplicationtest.state_management

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun NumberGuessScreenRoot(modifier: Modifier=Modifier){
    val viewModel= viewModel<NumberGuessViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    NumberGuessScreen(state, onAction = viewModel::onAction,modifier)
}



@Composable
fun NumberGuessScreen(state: NumberGuessState,
                      onAction: (NumberGuessAction)->Unit,
    modifier: Modifier=Modifier){

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = state.numberText.toString(),
            onValueChange = {
                onAction(NumberGuessAction.onNumberTextChange(it))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )

        )
        Button(onClick = { onAction(NumberGuessAction.onGuessClick) }) {
            Text(text = "Guess Number")
        }
        if (state.guessText!=null){
            Text(text = state.guessText)
        }
        if (state.isGuessCorrect){
            Button({onAction(NumberGuessAction.onStartNewGameButton)}) {
                Text(text = "Start New Game")
            }


        }
    }

}

