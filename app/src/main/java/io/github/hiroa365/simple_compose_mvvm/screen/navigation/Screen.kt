package io.github.hiroa365.simple_compose_mvvm.screen.navigation


sealed class Screen(val route: String) {
    object Main : Screen(route = "main")
}
