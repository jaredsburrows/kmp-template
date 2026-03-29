package com.kmptemplate.app.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
internal actual fun colorScheme(darkTheme: Boolean): ColorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()
