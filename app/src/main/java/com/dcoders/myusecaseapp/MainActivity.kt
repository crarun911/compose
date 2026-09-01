package com.dcoders.myusecaseapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dcoders.myusecaseapp.playground.BoxDemo
import com.dcoders.myusecaseapp.playground.CounterDemo
import com.dcoders.myusecaseapp.playground.LazyListDemo
import com.dcoders.myusecaseapp.playground.RowColumnDemo
import com.dcoders.myusecaseapp.ui.theme.MyUsecaseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterDemo()
        }
    }
}
