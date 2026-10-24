package org.stephennnamani.pursecheck.app.shell.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import org.stephennnamani.pursecheck.app.navigation.PurseCheckDestination

@Composable
internal fun rememberNavigationFocusRequesters(
    destinations: List<PurseCheckDestination>
): Map<PurseCheckDestination, FocusRequester> =
    remember(destinations){
        destinations.associateWith {
            FocusRequester()
        }
    }