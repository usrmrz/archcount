package dev.usrmrz.archcount.feature_state.data.repository

import dev.usrmrz.archcount.feature_state.domain.repository.CounterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class CounterRepositoryImpl @Inject constructor(): CounterRepository {

    private val _count = MutableStateFlow(0)
    override val count: StateFlow<Int> = _count

    override fun increment() {
        _count.value++
    }

    override fun reset() {
        _count.value = 0
    }
}