package dev.usrmrz.archcount.feature_state.presentation.counter

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.usrmrz.archcount.feature_state.domain.repository.CounterRepository
import dev.usrmrz.archcount.feature_state.domain.use_case.CountUseCases
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor (
    private val useCases: CountUseCases,
    repository: CounterRepository
) : ViewModel() {

    val count = repository.count

    fun increment() {
        useCases.increment()
    }

    fun reset() {
        useCases.reset()
    }
}