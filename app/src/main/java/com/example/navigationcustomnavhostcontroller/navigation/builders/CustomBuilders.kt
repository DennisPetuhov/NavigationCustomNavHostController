package com.example.navigationcustomnavhostcontroller.navigation.builders

import android.net.Uri
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import com.example.navigationcustomnavhostcontroller.navigation.destinations.CustomNavDestinations
import com.example.navigationcustomnavhostcontroller.navigation.first_graph.FirstGraphFirstScreen
import com.example.navigationcustomnavhostcontroller.navigation.first_graph.FirstGraphSecondScreen
import com.example.navigationcustomnavhostcontroller.navigation.first_graph.FirstGraphThirdScreen
import com.example.navigationcustomnavhostcontroller.navigation.first_graph.FirstScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.first_graph.SecondScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.first_graph.ThirdScreenDestination

fun NavGraphBuilder.firstNavGraph(
    navigateToDestination: (CustomNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
    customComposable(
        destinations = SecondScreenDestination,
        content = {
            FirstGraphSecondScreen(navigateToThirdScreens = {
                navigateToDestination(ThirdScreenDestination, null) {
//                    popUpTo(route = SPLASH_SCREEN) { inclusive = true }

                }
            })
        })

    customComposable(
        destinations = FirstScreenDestination,
        content = {
            FirstGraphFirstScreen(navigateToSecondScreen = {
                navigateToDestination(
                    SecondScreenDestination,
                    null
                ) {}
            })

        }
    )
    customComposable(
        destinations = ThirdScreenDestination,
        content = {
            FirstGraphThirdScreen(navigateToFirstScreen = {
                navigateToDestination(
                    FirstScreenDestination,
                    null
                ) {}
            })

        }
    )
}

fun NavGraphBuilder.secondNavGraph(
    navigateToDestination: (CustomNavDestinations, String?, (NavOptionsBuilder.() -> Unit)?) -> Unit,
    navigateByDeepLink: (Uri, (NavOptionsBuilder.() -> Unit)?) -> Unit,
) {
}
