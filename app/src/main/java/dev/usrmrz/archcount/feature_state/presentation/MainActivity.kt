package dev.usrmrz.archcount.feature_state.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import dev.usrmrz.archcount.feature_state.data.repository.MockCounterRepository
import dev.usrmrz.archcount.feature_state.domain.use_case.CounterUseCases
import dev.usrmrz.archcount.feature_state.domain.use_case.IncrementCounterUseCase
import dev.usrmrz.archcount.feature_state.domain.use_case.ResetCounterUseCase
import dev.usrmrz.archcount.feature_state.presentation.counter.CounterScreen
import dev.usrmrz.archcount.feature_state.presentation.counter.CounterViewModel
import dev.usrmrz.archcount.ui.theme.ArchitectureOfCountingTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchitectureOfCountingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    ) {
                        CounterScreen()
                    }
                }
            }
        }
    }
}

@Preview(name = "Empty State", showBackground = true)
@Composable
fun EmptyCounterScreenPreview() {

    val mockRepository = MockCounterRepository().apply { setCount(0) }
    val useCases = CounterUseCases(
        increment = IncrementCounterUseCase(mockRepository),
        reset = ResetCounterUseCase(mockRepository)
    )
    ArchitectureOfCountingTheme {
        CounterScreen(
            viewModel = CounterViewModel(useCases, mockRepository)
        )
    }
}

@Preview(name = "Filled State", showBackground = true)
@Composable
fun FilledCounterScreenPreview() {

    val mockRepository = MockCounterRepository()
    val useCases = CounterUseCases(
        increment = IncrementCounterUseCase(mockRepository),
        reset = ResetCounterUseCase(mockRepository)
    )
    ArchitectureOfCountingTheme {
        CounterScreen(
            viewModel = CounterViewModel(useCases, mockRepository)
        )
    }
}