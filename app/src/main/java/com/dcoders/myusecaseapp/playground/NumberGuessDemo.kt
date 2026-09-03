package com.dcoders.myusecaseapp.playground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun NumberGuessDemoRoot() {
    val viewModel = viewModel<NumberGuessViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    NumberGuessDemo(state,viewModel::onAction)
}

@Composable
fun NumberGuessDemo(state: NumberGuessState,
numberGuessAction: (NumberGuessAction)-> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = "${state.numberText}",
            onValueChange = { newText ->
                numberGuessAction(NumberGuessAction.onNumberTextChanged(newText))
            }
        )
        Button(onClick = {numberGuessAction(NumberGuessAction.onStartNewButton)}) {
            Text(text = "Reset")
        }
    }
}

@Preview
@Composable
fun NumberGuessDemoPreview() {
    NumberGuessDemo(
        state = NumberGuessState(),
        numberGuessAction = {}
    )
}