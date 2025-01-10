package dev.usrmrz.archcount.feature_state.presentation.counter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun CounterScreen() {

    var count by rememberSaveable { mutableIntStateOf(0) }

    CounterScreenStateless(count, { count++ }, { count = 0 })
}
