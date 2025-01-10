package dev.usrmrz.archcount.feature_state.presentation.util

fun getCounterText(count: Int): String {
    return if(count > 0) "You’ve had $count glass${if(count > 1) "es" else ""}" else ""
}