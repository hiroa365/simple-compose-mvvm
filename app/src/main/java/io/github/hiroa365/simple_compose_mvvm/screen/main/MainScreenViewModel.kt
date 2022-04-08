package io.github.hiroa365.simple_compose_mvvm.screen.main


import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(MainScreenState.initValue)
    val state = _state.asStateFlow()

    private fun currentState() = _state.value
    private fun updateState(newState: () -> MainScreenState) {
        _state.value = newState()
    }

    fun onEvent(event: MainViewEvent) {
        when (event) {
            OnClickCountUpEvent -> onClickCountUpEvent()
        }
    }

    private fun onClickCountUpEvent() {
        val oldState = currentState()
        updateState { oldState.copy(counter = oldState.counter + 1) }
    }
}
