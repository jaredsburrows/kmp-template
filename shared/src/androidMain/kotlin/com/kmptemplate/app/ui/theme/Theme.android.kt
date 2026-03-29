package com.kmptemplate.app.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
internal actual fun colorScheme(darkTheme: Boolean): ColorScheme {
  val context = LocalContext.current
  return if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
}
