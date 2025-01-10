package dev.usrmrz.archcount.feature_state.presentation.util

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CounterButton(onClick: () -> Unit, buttonText: String, enabled: Boolean = true, minWidth: Int = 128) {
    return Button(
        onClick = onClick,
        modifier = Modifier
            .padding(top = 16.dp)
            .defaultMinSize(minWidth = minWidth.dp),
        enabled = enabled
    ) { Text(buttonText) }
}