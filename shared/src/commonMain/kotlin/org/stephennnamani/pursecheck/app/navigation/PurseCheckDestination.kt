package org.stephennnamani.pursecheck.app.navigation

internal enum class PurseCheckDestination(
    val group: PurseCheckNavigationGroup
) {
    Overview(
        group = PurseCheckNavigationGroup.Primary
    ),
    Transactions(
        group = PurseCheckNavigationGroup.Primary
    ),
    Budgets(
        group = PurseCheckNavigationGroup.Primary
    ),
    Accounts(
        group = PurseCheckNavigationGroup.Secondary
    ),
    Analytics(
        group = PurseCheckNavigationGroup.Secondary
    ),
    Goals(
        group = PurseCheckNavigationGroup.Secondary
    ),
    Settings(
        group = PurseCheckNavigationGroup.Secondary
    ),
    Help(
        group = PurseCheckNavigationGroup.Secondary
    )
}

internal val primaryDestinations =
    PurseCheckDestination.entries.filter {
        it.group == PurseCheckNavigationGroup.Primary
    }

internal  val secondaryDestinations =
    PurseCheckDestination.entries.filter {
        it.group == PurseCheckNavigationGroup.Secondary
    }