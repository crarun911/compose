package com.dcoders.myapplicationtest.note_management

import android.graphics.Color
import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun NoteMakerScreenRoot(modifier: Modifier= Modifier) {
    val viewModel = viewModel<TodoViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    NoteMakerScreen(
        modifier = modifier,
        state = state,
        onAction = viewModel::onAction
    )

}


@Composable
fun NoteMakerScreen(
    modifier: Modifier,
    state: List<Todo>,
    onAction: (TodoAction) -> Unit
) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(androidx.compose.ui.graphics.Color(Color.RED))

    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Bold,
            text = "Unchecked"
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.1f)
                .padding(10.dp)
                .background(color = androidx.compose.ui.graphics.Color.LightGray),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 5.dp, top = 8.dp),
                text = "Bring out the trash",
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 5.dp, bottom = 8.dp),
                text = "Better do this before wife comes home"
            )

            Checkbox(
                modifier = Modifier.align(Alignment.CenterEnd),
                checked = state.get(0).isComplete,
                onCheckedChange = {
                    onAction(TodoAction.CompleteChanged(state.get(0).id,it))
                }
            )

        }
        Text(
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Bold,
            text = "Checked"
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.1f)
                .padding(10.dp)
                .background(color = androidx.compose.ui.graphics.Color.LightGray),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 5.dp, top = 8.dp),
                text = "Bring out the trash",
                textDecoration = TextDecoration.LineThrough,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 5.dp, bottom = 8.dp),
                textDecoration = TextDecoration.LineThrough,
                text = "Better do this before wife comes home"

            )
            Checkbox(
                modifier = Modifier.align(Alignment.CenterEnd),
                checked = state.get(1).isComplete,
                onCheckedChange = {
                    onAction(TodoAction.CompleteChanged(state.get(0).id,it))
                }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun NoteMakerScreenPreview() {
    NoteMakerScreenRoot(modifier = Modifier.fillMaxSize())
}