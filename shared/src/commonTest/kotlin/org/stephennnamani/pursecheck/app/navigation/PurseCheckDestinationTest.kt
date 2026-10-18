package org.stephennnamani.pursecheck.app.navigation

import kotlin.test.Test
import kotlin.test.assertEquals

class PurseCheckDestinationTest {
    @Test
    fun primaryNavigationContainOnlyPrimaryDestinations() {
        assertEquals(
            listOf(
                PurseCheckDestination.Overview,
                PurseCheckDestination.Transactions,
                PurseCheckDestination.Budgets
            ),
            primaryDestinations
        )
    }

    @Test
    fun secondaryNavigationContainOnlySecondaryDestinations() {
        assertEquals(
            listOf(
                PurseCheckDestination.Accounts,
                PurseCheckDestination.Analytics,
                PurseCheckDestination.Goals,
                PurseCheckDestination.Settings,
                PurseCheckDestination.Help
            ),
            secondaryDestinations
        )
    }
}