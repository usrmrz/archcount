package dev.usrmrz.archcount.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.usrmrz.archcount.feature_state.data.repository.CounterRepositoryImpl
import dev.usrmrz.archcount.feature_state.domain.repository.CounterRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindCounterRepository(
        impl: CounterRepositoryImpl
    ): CounterRepository
}