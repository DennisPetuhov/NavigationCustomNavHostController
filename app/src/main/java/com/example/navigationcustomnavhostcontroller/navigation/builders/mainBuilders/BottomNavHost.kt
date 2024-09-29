package com.example.navigationcustomnavhostcontroller.navigation.builders.mainBuilders

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.navigationcustomnavhostcontroller.navigation.animations.CustomNavAnimations
import com.example.navigationcustomnavhostcontroller.navigation.animations.SlidingAnimations
import com.example.navigationcustomnavhostcontroller.navigation.destinations.CustomNavDestinations

@Composable
fun BottomNavHost(
    navController: NavHostController,
    startDestination: CustomNavDestinations,
    animations: CustomNavAnimations = SlidingAnimations,
    builder: NavGraphBuilder.() -> Unit,
) {
    CustomNavHost(
        navController = navController,
        startDestination = startDestination,
        animations = animations,
        builder = builder
    )
}