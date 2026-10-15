package org.stephennnamani.pursecheck.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
internal data class PurseCheckExtendedColors(
    val success: Color,
    val onSuccess: Color,
    val successContainer: Color,
    val onSuccessContainer: Color,

    val warning: Color,
    val onWarning: Color,
    val warningContainer: Color,
    val onWarningContainer: Color,

    val info: Color,
    val onInfo: Color,
    val infoContainer: Color,
    val onInfoContainer: Color,

    val income: Color,
    val expense: Color,
    val savings: Color,
    val neutralAmount: Color,
)

internal val purseCheckLightExtendedColors =
    PurseCheckExtendedColors(
        success = PurseCheckPrimitiveColors.Green700,
        onSuccess = PurseCheckPrimitiveColors.Neutral0,
        successContainer = PurseCheckPrimitiveColors.Green50,
        onSuccessContainer = PurseCheckPrimitiveColors.Green700,

        warning = PurseCheckPrimitiveColors.Amber700,
        onWarning = PurseCheckPrimitiveColors.Neutral0,
        warningContainer = PurseCheckPrimitiveColors.Amber50,
        onWarningContainer = PurseCheckPrimitiveColors.Amber700,

        info = PurseCheckPrimitiveColors.Blue700,
        onInfo = PurseCheckPrimitiveColors.Neutral0,
        infoContainer = PurseCheckPrimitiveColors.Blue50,
        onInfoContainer = PurseCheckPrimitiveColors.Blue700,

        income = PurseCheckPrimitiveColors.Green700,
        expense = PurseCheckPrimitiveColors.Red700,
        savings = PurseCheckPrimitiveColors.Mint700,
        neutralAmount = PurseCheckPrimitiveColors.Neutral600,
    )