package com.dcoders.myusecaseapp.retrofitexample.dataclasses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dcoders.myusecaseapp.retrofitexample.MainRetroViewModel


@Composable
fun showHarryPotterData(viewModel: MainRetroViewModel){
    val state=viewModel.harryPotterData.observeAsState()
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        state.value?.let { Text(text = it) }
    }



}