package io.github.hiroa365.simple_compose_mvvm.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel(),
) {

    val state by viewModel.state.collectAsState()

    MainScreen(
        state = state,
        onClickCountUp = { viewModel.onEvent(OnClickCountUpEvent) }
    )
}

@Composable
fun MainScreen(
    state: MainScreenState,
    onClickCountUp: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = state.counter.toString())
        Button(onClick = onClickCountUp) {
            Text(text = "Count Up")
        }
    }
}
