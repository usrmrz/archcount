package dev.usrmrz.archcount.feature_state.domain.use_case

import dev.usrmrz.archcount.feature_state.domain.repository.CounterRepository

class IncrementCountUseCase(
    private val repository: CounterRepository
) {
    operator fun invoke() {
        repository.increment()
    }
}