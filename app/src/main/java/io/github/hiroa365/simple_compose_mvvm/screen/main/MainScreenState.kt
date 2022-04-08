package io.github.hiroa365.simple_compose_mvvm.screen.main

data class MainScreenState(
    val counter: Int
) {
    companion object {
        val initValue = MainScreenState(counter = 0)
    }
}
