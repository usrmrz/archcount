package dev.usrmrz.archcount.feature_state.domain.repository

import kotlinx.coroutines.flow.StateFlow

interface CounterRepository {

    val count: StateFlow<Int>
    fun increment()
    fun reset()
}