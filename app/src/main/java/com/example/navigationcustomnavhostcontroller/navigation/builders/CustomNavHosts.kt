package com.example.navigationcustomnavhostcontroller.navigation.builders

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.navigationcustomnavhostcontroller.navigation.builders.mainBuilders.CustomNavHost
import com.example.navigationcustomnavhostcontroller.navigation.destinations.AuthGraphFirstScreenDestination


@Composable
fun AuthNavHost(
    navController: NavHostController,
    customNavController: CustomNavController
) {
    var selectedItem = remember { mutableIntStateOf(0)}
    CustomNavHost(
        navController = navController,
        startDestination = remember { AuthGraphFirstScreenDestination }
    ) {
        authNavGraph(
            navigateToDestination = customNavController::navigate,
            navigateByDeepLink = customNavController::navigate
        )
        bottomNavGraph(
            selectedItem = selectedItem,
            navigateToDestination = customNavController::navigate,
            navigateByDeepLink = customNavController::navigate
        )

//        mainGraph(navController, customNavController,
//            navigateToDestination = customNavController::navigate,
//            navigateByDeepLink = customNavController::navigate
//        )
    }
}

//@Composable
//fun NavBarNavHost(customNavController: CustomNavController) {
//    CustomNavHost(
//        navController = rememberNavController(),
//        startDestination = remember { BottomGraphFirstScreenDestination }) {
//        bottomGraph(
//            navigateToDestination = customNavController::navigate,
//            navigateByDeepLink = customNavController::navigate
//        )
//    }
//}
