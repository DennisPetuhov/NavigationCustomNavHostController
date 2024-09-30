package com.example.navigationcustomnavhostcontroller.navigation.builders

import android.net.Uri
import androidx.compose.runtime.MutableIntState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import com.example.navigationcustomnavhostcontroller.navigation.builders.mainBuilders.customComposable
import com.example.navigationcustomnavhostcontroller.navigation.destinations.AuthGraphFirstScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.AuthGraphSecondScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.AuthGraphThirdScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.CustomNavDestinations
import com.example.navigationcustomnavhostcontroller.navigation.destinations.NavBarFirstScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.NavBarSecondScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.NavBarThirdScreenDestination
import com.example.navigationcustomnavhostcontroller.ui.screens.AuthGraphFirstScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.AuthGraphSecondScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.AuthGraphThirdScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.NavBarFirstScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.NavBarSecondScreen
import com.example.navigationcustomnavhostcontroller.ui.screens.NavBarThirdScreen

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
                    NavBarFirstScreenDestination,
                    null
                ) {}
            })

        }
    )
}

fun NavGraphBuilder.bottomNavGraph(
    selectedItem: MutableIntState,
    navigateToDestination: (CustomNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {

    customComposable(
        destinations = NavBarFirstScreenDestination,
        content = {
            NavBarFirstScreen(navigateToSecondScreen = {
                navigateToDestination(
                    NavBarSecondScreenDestination,
                    null,
                    null
                )
            }, navigateByNavBar = {
                navigateToDestination(it, null, null)
            }, selectedItem = selectedItem)
        })

    customComposable(
        destinations = NavBarSecondScreenDestination,
        content = {
            NavBarSecondScreen(navigateToThirdScreens = {
                navigateToDestination(
                    NavBarThirdScreenDestination,
                    null,
                    null
                )
            }, navigateByNavBar = {
                navigateToDestination(it, null, null)
            },selectedItem= selectedItem)
        })
    customComposable(
        destinations = NavBarThirdScreenDestination,
        content = {
            NavBarThirdScreen(navigateToAuth = {
                navigateToDestination(
                    AuthGraphFirstScreenDestination,
                    null,
                    null
                )
            }, navigateByNavBar = {
                navigateToDestination(it, null, null)
            }, selectedItem = selectedItem)
        })
}