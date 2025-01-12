package dev.usrmrz.archcount.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dev.usrmrz.archcount.feature_state.domain.repository.CounterRepository
import dev.usrmrz.archcount.feature_state.domain.use_case.CountUseCases
import dev.usrmrz.archcount.feature_state.domain.use_case.IncrementCountUseCase
import dev.usrmrz.archcount.feature_state.domain.use_case.ResetCountUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideCountUseCases(repository: CounterRepository): CountUseCases {
        return CountUseCases(
            increment = IncrementCountUseCase(repository),
            reset = ResetCountUseCase(repository)
        )
    }

}