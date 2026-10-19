package org.stephennnamani.pursecheck.app.navigation

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.stephennnamani.pursecheck.resources.Res
import org.stephennnamani.pursecheck.resources.ic_accounts
import org.stephennnamani.pursecheck.resources.ic_analytics
import org.stephennnamani.pursecheck.resources.ic_budget
import org.stephennnamani.pursecheck.resources.ic_goals
import org.stephennnamani.pursecheck.resources.ic_help
import org.stephennnamani.pursecheck.resources.ic_overview
import org.stephennnamani.pursecheck.resources.ic_settings
import org.stephennnamani.pursecheck.resources.ic_transactions
import org.stephennnamani.pursecheck.resources.nav_accounts
import org.stephennnamani.pursecheck.resources.nav_analytics
import org.stephennnamani.pursecheck.resources.nav_budgets
import org.stephennnamani.pursecheck.resources.nav_goals
import org.stephennnamani.pursecheck.resources.nav_help
import org.stephennnamani.pursecheck.resources.nav_overview
import org.stephennnamani.pursecheck.resources.nav_settings
import org.stephennnamani.pursecheck.resources.nav_transactions

internal val PurseCheckDestination.labelResources: StringResource
    get() =
        when (this) {
            PurseCheckDestination.Overview -> Res.string.nav_overview
            PurseCheckDestination.Transactions -> Res.string.nav_transactions
            PurseCheckDestination.Budgets -> Res.string.nav_budgets
            PurseCheckDestination.Accounts -> Res.string.nav_accounts
            PurseCheckDestination.Analytics -> Res.string.nav_analytics
            PurseCheckDestination.Goals -> Res.string.nav_goals
            PurseCheckDestination.Settings -> Res.string.nav_settings
            PurseCheckDestination.Help -> Res.string.nav_help
        }

internal val PurseCheckDestination.iconResource: DrawableResource
    get() =
        when(this) {
            PurseCheckDestination.Overview -> Res.drawable.ic_overview
            PurseCheckDestination.Transactions -> Res.drawable.ic_transactions
            PurseCheckDestination.Budgets -> Res.drawable.ic_budget
            PurseCheckDestination.Accounts -> Res.drawable.ic_accounts
            PurseCheckDestination.Analytics -> Res.drawable.ic_analytics
            PurseCheckDestination.Goals -> Res.drawable.ic_goals
            PurseCheckDestination.Settings -> Res.drawable.ic_settings
            PurseCheckDestination.Help -> Res.drawable.ic_help
        }