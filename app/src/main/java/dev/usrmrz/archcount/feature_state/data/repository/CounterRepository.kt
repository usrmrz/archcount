package dev.usrmrz.archcount.feature_state.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class CounterRepository @Inject constructor() {

    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count

    fun increment() {
        _count.value++
    }

    fun reset() {
        _count.value = 0
    }
}