package com.example.navigationcustomnavhostcontroller.navigation.builders

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigationcustomnavhostcontroller.navigation.builders.mainBuilders.BottomNavHost
import com.example.navigationcustomnavhostcontroller.navigation.builders.mainBuilders.CustomNavHost
import com.example.navigationcustomnavhostcontroller.navigation.destinations.AuthGraphFirstScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.BottomGraphFirstScreenDestination


@Composable
fun MainAuthNavHost(
    navController: NavHostController,
    customNavController: CustomNavController
) {
    CustomNavHost(
        navController = navController,
        startDestination = remember { AuthGraphFirstScreenDestination }
    ) {
        authNavGraph(
            navigateToDestination = customNavController::navigate,
            navigateByDeepLink = customNavController::navigate
        )
        mainGraph(
            navigateToDestination = customNavController::navigate,
            navigateByDeepLink = customNavController::navigate
        )
    }
}

@Composable
fun MainBottomNavHost(customNavController: CustomNavController) {
    BottomNavHost(
        navController = rememberNavController(),
        startDestination = remember { BottomGraphFirstScreenDestination }) {
        bottomGraph(
            navigateToDestination = customNavController::navigate,
            navigateByDeepLink = customNavController::navigate
        )
    }
}
