package io.github.hiroa365.simple_compose_mvvm.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel(),
) {
    /**
     * ViewModelで保持しているStateを監視
     * 変化があった場合は再コンポーズされる
     */
    val state by viewModel.state.collectAsState()

    /**
     * ViewModelがこの関数内だけで使用するため、
     * ViewModelにイベントを渡す場合は、Eventを送るためのリスナーを渡している
     */
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
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /**
         * Stateのカウンターを表示する
         */
        Text(text = state.counter.toString())

        /**
         * ボタン押下でStateのカウンターを直接カウントアップせずに、
         * クリックイベントをViewModelに投げる
         */
        Button(onClick = onClickCountUp) {
            Text(text = "Count Up")
        }
    }
}
