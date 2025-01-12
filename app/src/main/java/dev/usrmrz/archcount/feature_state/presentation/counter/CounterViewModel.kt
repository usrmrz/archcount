package dev.usrmrz.archcount.feature_state.presentation.counter

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.usrmrz.archcount.feature_state.domain.repository.CounterRepository
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor (
    private val repository: CounterRepository
) : ViewModel() {

    val count = repository.count

    fun increment() {
        repository.increment()
    }

    fun reset() {
        repository.reset()
    }
}