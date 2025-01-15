package dev.usrmrz.archcount.feature_state.domain.use_case

class CounterUseCases(
    val increment: IncrementCounterUseCase,
    val reset: ResetCounterUseCase
)