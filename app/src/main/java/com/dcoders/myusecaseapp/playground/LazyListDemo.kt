package com.dcoders.myusecaseapp.playground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyListDemo(){
    Scaffold(topBar = {
        TopAppBar(title={
            Text("My first Scaffold")},
            navigationIcon = {
             IconButton(onClick = {}) {
                 Icon(
                     Icons.Default.ArrowBack,
                     contentDescription = "go back"
                 )
             }
            }
        )
    }) { paddingValues ->
        LazyVerticalGrid(modifier = Modifier.padding(top=paddingValues.calculateTopPadding()),

            columns = GridCells.Fixed(10)

        ) {
            items(count=100) {
                Box(modifier = Modifier
                    .size(100.dp)
                    .background(Color(Random.nextInt()))
                )
            }
        }
    }
    
}
@Preview
@Composable
fun Preview(){
LazyListDemo()
}