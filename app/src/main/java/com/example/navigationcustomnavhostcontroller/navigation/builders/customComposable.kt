package com.example.navigationcustomnavhostcontroller.navigation.builders

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigationcustomnavhostcontroller.navigation.destinations.CustomNavDestinations

fun NavGraphBuilder.customComposable(
    destinations: CustomNavDestinations,
    arguments: List<NamedNavArgument> = destinations.arguments,
    deepLinks: List<NavDeepLink> = destinations.getDeepLinks(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit,
) {
    composable(
        route = destinations.route,
        arguments = arguments,
        deepLinks = deepLinks,
        enterTransition = destinations.enterTransition,
        exitTransition = destinations.exitTransition,
        popEnterTransition = destinations.popEnterTransition,
        popExitTransition = destinations.popExitTransition,
        content = content,
    )
}