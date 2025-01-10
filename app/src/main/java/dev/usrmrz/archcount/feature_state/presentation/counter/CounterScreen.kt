package dev.usrmrz.archcount.feature_state.presentation.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.usrmrz.archcount.feature_state.presentation.util.CounterButton
import dev.usrmrz.archcount.feature_state.presentation.util.getCounterText

@Composable
fun CounterScreen() {

    var count by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = getCounterText(count),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CounterButton({ count++ }, "ADD", count < 10)
            CounterButton({ count = 0 }, "CLEAR")
        }
    }
}
