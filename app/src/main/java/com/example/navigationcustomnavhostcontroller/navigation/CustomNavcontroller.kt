package com.example.navigationcustomnavhostcontroller.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import com.example.navigationcustomnavhostcontroller.navigation.destinations.CustomNavDestinations
import com.example.navigationcustomnavhostcontroller.navigation.first_graph.Screens

@Composable
fun rememberCustomNavController(navController: NavHostController): CustomNavController {
    return remember(navController) {
        CustomNavController(navController)
    }
}

class CustomNavController(private val navController: NavHostController) {
    fun navigate(
        destinations: CustomNavDestinations?,
        route: String? = null,
        navOptionsBuilder: (NavOptionsBuilder.() -> Unit)? = null,
    ) {
//        Timber.tag("Routing").d("routes  ${destinations?.route} $route")
        navController.navigate(route ?: destinations?.route ?: Screens.First.route) {
            navOptionsBuilder?.invoke(this)
        }
    }

    fun navigate(deepLink: Uri, navOptionsBuilder: (NavOptionsBuilder.() -> Unit)? = null) {
        val builder: NavOptionsBuilder.() -> Unit = {
            launchSingleTop = false
            navOptionsBuilder?.invoke(this)
        }
        try {
            navController.navigate(deepLink, navOptions(builder))
        } catch (e: Exception) {
//            Timber.d("EXCEPTION: ${e.message}")
        }
    }
}