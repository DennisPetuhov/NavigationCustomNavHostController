package com.example.navigationcustomnavhostcontroller.navigation.builders

import android.net.Uri
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import com.example.navigationcustomnavhostcontroller.navigation.destinations.CustomNavDestinations
import com.example.navigationcustomnavhostcontroller.ui.screens.AuthGraphFirstScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.AuthGraphSecondScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.AuthGraphThirdScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.AuthGraphFirstScreenDestination
import com.example.navigationcustomnavhostcontroller.ui.screens.AuthGraphSecondScreenDestination
import com.example.navigationcustomnavhostcontroller.ui.screens.AuthGraphThirdScreenDestination
import com.example.navigationcustomnavhostcontroller.ui.screens.MainGraphFirstScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.MainGraphFirstScreenDestination
import com.example.navigationcustomnavhostcontroller.ui.screens.MainGraphSecondScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.MainGraphSecondScreenDestination

fun NavGraphBuilder.authNavGraph(
    navigateToDestination: (CustomNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    customComposable(
        destinations = AuthGraphSecondScreenDestination,
        content = {
            AuthGraphSecondScreen(navigateToThirdScreens = {
                navigateToDestination(AuthGraphThirdScreenDestination, null) {
//                    popUpTo(route = SPLASH_SCREEN) { inclusive = true }

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
            AuthGraphThirdScreen(navigateToFirstScreen = {
                navigateToDestination(
                    MainGraphFirstScreenDestination,
                    null
                ) {}
            })

        }
    )
}

fun NavGraphBuilder.mainNavGraph(
    navigateToDestination: (CustomNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {

    customComposable(
        destinations = MainGraphFirstScreenDestination,
        content = {
            MainGraphFirstScreen(navigateToSecondScreen =  {
                navigateToDestination(MainGraphSecondScreenDestination, null) {
                }
            })
        })

    customComposable(
        destinations = MainGraphFirstScreenDestination,
        content = {
            MainGraphSecondScreen(navigateToThirdScreens =  {
                navigateToDestination(
                    AuthGraphSecondScreenDestination,
                    null
                ) {}
            })

        }
    )
}
