package dev.usrmrz.archcount.feature_state.presentation.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.usrmrz.archcount.feature_state.data.repository.MockCounterRepository
import dev.usrmrz.archcount.feature_state.domain.use_case.CounterUseCases
import dev.usrmrz.archcount.feature_state.domain.use_case.IncrementCounterUseCase
import dev.usrmrz.archcount.feature_state.domain.use_case.ResetCounterUseCase
import dev.usrmrz.archcount.feature_state.presentation.util.CounterButton
import dev.usrmrz.archcount.feature_state.presentation.util.getCounterText
import dev.usrmrz.archcount.ui.theme.ArchitectureOfCountingTheme

@Composable
fun CounterScreen(viewModel: CounterViewModel = hiltViewModel()) {

    val count by viewModel.count.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = getCounterText(count),
            fontSize = 24.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight.Bold,
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CounterButton({ viewModel.increment() }, "Add", count < 10)
            CounterButton({ viewModel.reset() }, "Clear")
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