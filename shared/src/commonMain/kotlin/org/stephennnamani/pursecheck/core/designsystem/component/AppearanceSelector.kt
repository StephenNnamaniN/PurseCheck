package org.stephennnamani.pursecheck.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import org.jetbrains.compose.resources.stringResource
import org.stephennnamani.pursecheck.core.designsystem.theme.PurseCheckTheme
import org.stephennnamani.pursecheck.core.designsystem.theme.ThemeMode
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.appearance_dark
import org.stephennnamani.pursecheck.resources.appearance_description
import org.stephennnamani.pursecheck.resources.appearance_light
import org.stephennnamani.pursecheck.resources.appearance_system
import org.stephennnamani.pursecheck.resources.appearance_title

@Composable
internal fun AppearanceSelector(
    selectedMode: ThemeMode,
    onModeSelected: (ThemeMode) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(
            PurseCheckTheme.spacing.space12
        )
    ){
        Text(
            text = stringResource(Res.string.appearance_title),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.semantics {
                heading()
            }
        )

        Text(
            text = stringResource(Res.string.appearance_description),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        val modes = ThemeMode.entries

        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            modes.forEachIndexed { index, mode ->
                SegmentedButton(
                    modifier = Modifier.weight(1f),
                    selected = selectedMode == mode,
                    onClick = {
                        onModeSelected(mode)
                    },
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = modes.size
                    ),
                    label = {
                        Text(
                            text = when (mode) {
                                ThemeMode.System -> stringResource(Res.string.appearance_system)
                                ThemeMode.Light -> stringResource(Res.string.appearance_light)
                                ThemeMode.Dark -> stringResource(Res.string.appearance_dark)
                            }
                        )
                    }
                )
            }
        }
    }
}