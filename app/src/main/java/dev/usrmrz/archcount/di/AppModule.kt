package dev.usrmrz.archcount.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.usrmrz.archcount.feature_state.data.repository.CounterRepositoryImpl
import dev.usrmrz.archcount.feature_state.domain.repository.CounterRepository
import dev.usrmrz.archcount.feature_state.domain.use_case.CountUseCases
import dev.usrmrz.archcount.feature_state.domain.use_case.IncrementCountUseCase
import dev.usrmrz.archcount.feature_state.domain.use_case.ResetCountUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCounterRepository(): CounterRepository {
        return CounterRepositoryImpl()
    }

    @Provides
    fun provideCountUseCases(repository: CounterRepository): CountUseCases {
        return CountUseCases(
            increment = IncrementCountUseCase(repository),
            reset = ResetCountUseCase(repository)
        )
    }
}