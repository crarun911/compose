package com.dcoders.myusecaseapp.playground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier



@Composable
fun CounterDemo(counter: Int,
                onCounterClick:()-> Unit,
                modifier: Modifier) {

    Box(
        contentAlignment = Alignment.Center
    ) {
        Button(onClick =
            onCounterClick
        ) {
            Text("count${counter}")
        }
    }
}