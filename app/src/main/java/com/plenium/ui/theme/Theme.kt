package com.plenium.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF6B4423),
    secondary = androidx.compose.ui.graphics.Color(0xFF8B6F47),
    tertiary = androidx.compose.ui.graphics.Color(0xFFD4A574)
)

@Composable
fun PleniumTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}
