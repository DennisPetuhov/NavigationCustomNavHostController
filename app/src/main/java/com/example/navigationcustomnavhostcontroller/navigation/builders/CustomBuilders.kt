package com.example.navigationcustomnavhostcontroller.navigation.builders

import android.net.Uri
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import com.example.navigationcustomnavhostcontroller.navigation.builders.mainBuilders.customComposable
import com.example.navigationcustomnavhostcontroller.navigation.destinations.AuthGraphFirstScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.AuthGraphSecondScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.AuthGraphThirdScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.BottomGraphDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.BottomGraphFirstScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.CustomNavDestinations
import com.example.navigationcustomnavhostcontroller.ui.screens.AuthGraphFirstScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.AuthGraphSecondScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.AuthGraphThirdScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.BottomBarScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.BottomGraphFirstScreen

fun NavGraphBuilder.authNavGraph(
    navigateToDestination: (CustomNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    customComposable(
        destinations = AuthGraphSecondScreenDestination,
        content = {
            AuthGraphSecondScreen(navigateToThirdScreens = {
                navigateToDestination(AuthGraphThirdScreenDestination, null) {
                }
            })
        })

    customComposable(
        destinations = AuthGraphFirstScreenDestination,
        content = {
            AuthGraphFirstScreen(navigateToSecondScreen = {
                navigateToDestination(
                    AuthGraphSecondScreenDestination,
                    null
                ) {}
            })

        }
    )
    customComposable(
        destinations = AuthGraphThirdScreenDestination,
        content = {
            AuthGraphThirdScreen(navigateToBottomNavigation = {
                navigateToDestination(
                    BottomGraphDestination,
                    null
                ) {}
            })

        }
    )
}

fun NavGraphBuilder.mainGraph(
    navigateToDestination: (CustomNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    customComposable(destinations = BottomGraphDestination, content = { BottomBarScreen() })
}

fun NavGraphBuilder.bottomGraph(
    navigateToDestination: (CustomNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    customComposable(
        destinations = BottomGraphFirstScreenDestination,
        content = {
            BottomGraphFirstScreen(navigateToSecondScreen = {})
        })
}

