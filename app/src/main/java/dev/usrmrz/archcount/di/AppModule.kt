package dev.usrmrz.archcount.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.usrmrz.archcount.feature_state.data.repository.CounterRepositoryImpl
import dev.usrmrz.archcount.feature_state.domain.repository.CounterRepository
import dev.usrmrz.archcount.feature_state.domain.use_case.CounterUseCases
import dev.usrmrz.archcount.feature_state.domain.use_case.IncrementCounterUseCase
import dev.usrmrz.archcount.feature_state.domain.use_case.ResetCounterUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCounterRepository(
        impl: CounterRepositoryImpl
    ): CounterRepository
}

@Module
@InstallIn(SingletonComponent::class)

object UseCasesModule {

    @Provides
    @Singleton
    fun provideCounterUseCases(repository: CounterRepository): CounterUseCases {
        return CounterUseCases(
            increment = IncrementCounterUseCase(repository),
            reset = ResetCounterUseCase(repository)
        )
    }
}