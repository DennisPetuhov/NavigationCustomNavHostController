package com.example.navigationcustomnavhostcontroller.navigation.builders.mainBuilders


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.navigationcustomnavhostcontroller.navigation.destinations.CustomNavDestinations
import com.example.navigationcustomnavhostcontroller.navigation.animations.CustomNavAnimations
import com.example.navigationcustomnavhostcontroller.navigation.animations.SlidingAnimations

@Composable
fun CustomNavHost(
    navController: NavHostController,
    startDestination: CustomNavDestinations,
    animations: CustomNavAnimations = SlidingAnimations,
    builder: NavGraphBuilder.() -> Unit,
) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = startDestination.route,
        enterTransition = animations.enterTransition,
        exitTransition = animations.exitTransition,
        popEnterTransition = animations.popEnterTransition,
        popExitTransition = animations.popExitTransition,
        builder = builder
    )
}




