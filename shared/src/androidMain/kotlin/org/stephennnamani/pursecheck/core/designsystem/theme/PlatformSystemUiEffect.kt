package org.stephennnamani.pursecheck.core.designsystem.theme

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
internal actual fun PlatformSystemUiEffect(
    isDarkTheme: Boolean
){
    val view = LocalView.current

    if (view.isInEditMode){
        return
    }

    val activity = view.context.findActivity() ?: return

    SideEffect {
        val window = activity.window
        val controller = WindowCompat.getInsetsController(
            window,
            window.decorView
        )
        controller.isAppearanceLightStatusBars = !isDarkTheme
        controller.isAppearanceLightNavigationBars = !isDarkTheme
    }
}

private tailrec fun Context.findActivity(): Activity? =
    when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }
