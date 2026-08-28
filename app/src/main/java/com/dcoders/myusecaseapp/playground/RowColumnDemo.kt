package com.dcoders.myusecaseapp.playground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dcoders.myusecaseapp.ui.theme.MyUsecaseAppTheme


@Composable
fun RowColumnDemo(modifier: Modifier= Modifier){

    Row(modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "My name is ",
            fontSize = 45.sp
                    , modifier = Modifier
            .alignByBaseline()
        )
        Text(text = "Arun ",
            fontSize = 20.sp
            , modifier = Modifier
                .alignByBaseline()
        )
//        Box(modifier = Modifier.size(100.dp)
//            .background(Color.Blue)
//            .alignByBaseline()
//        )
//        Box(modifier = Modifier.size(100.dp)
//            .background(Color.Red)
//        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xffff
)
@Composable
private fun RowColumnPreview(){
    MyUsecaseAppTheme() {
        RowColumnDemo()
    }
}