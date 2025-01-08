package dev.usrmrz.archcount.state_feature.presentation.counter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CounterScreen() {

    var count by rememberSaveable() { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.padding(top = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Count: $count",
            modifier = Modifier.padding(bottom = 16.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Button(
            onClick = { count++ },
            modifier = Modifier
                .defaultMinSize(minWidth = 128.dp),
            enabled = count < 10,
        ) { Text("ADD") }
        Button(
            onClick = { count = 0 },
            modifier = Modifier
                .padding(top = 16.dp)
                .defaultMinSize(minWidth = 128.dp),
            enabled = count == 10,
        ) { Text("CLEAR") }
    }
}