package com.example.chatinterface.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LightColorPalette = CustomColors(
    material = lightColors(
        primary = Purple500,
        primaryVariant = Purple700,
        secondary = Teal200
    ),
    senderCardBackground = SenderLight,
    receiverCardBackground = ReceiverLight
)

private val DarkColorPalette = CustomColors(
    material = darkColors(
        primary = Purple200,
        primaryVariant = Purple700,
        secondary = Teal200
    ),
    senderCardBackground = SenderDark,
    receiverCardBackground = ReceiverDark

)

private val LocalColors = staticCompositionLocalOf { LightColorPalette }

@Composable
fun ChatInterfaceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(LocalColors provides colors) {
        MaterialTheme(
            colors = colors.material,
            typography = Typography,
            shapes = Shapes,
            content = content,
        )
    }
}

val MaterialTheme.customColors: CustomColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current