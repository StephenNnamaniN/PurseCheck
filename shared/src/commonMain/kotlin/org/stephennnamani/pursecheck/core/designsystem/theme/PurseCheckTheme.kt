package org.stephennnamani.pursecheck.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalPurseCheckExtendedColors =
    staticCompositionLocalOf<PurseCheckExtendedColors> {
        error("PurseCheck extended colors have not been provided.")
    }

@Composable
internal fun PurseCheckTheme(
    content: @Composable () -> Unit
){
    CompositionLocalProvider(
        LocalPurseCheckExtendedColors provides purseCheckLightExtendedColors
    ){
        MaterialTheme(
            colorScheme = purseCheckLightColorScheme,
            typography = purseCheckTypography(),
            shapes = purseCheckShapes,
            content = content
        )
    }
}

internal object PurseCheckTheme {

    val colors: PurseCheckExtendedColors
        @Composable
        get() = LocalPurseCheckExtendedColors.current

    val spacing: PurseCheckSpacing
        get() = PurseCheckSpacing

    val elevation: PurseCheckElevation
        get() = PurseCheckElevation
}