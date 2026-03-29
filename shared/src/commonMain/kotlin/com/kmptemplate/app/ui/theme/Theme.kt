package com.kmptemplate.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun GifTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit,
) {
  MaterialTheme(
    colorScheme = colorScheme(darkTheme),
    typography = MaterialTheme.typography,
    content = content,
  )
}

@Composable
internal expect fun colorScheme(darkTheme: Boolean): ColorScheme
