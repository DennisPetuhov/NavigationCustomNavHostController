package com.example.navigationcustomnavhostcontroller.navigation.first_graph

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NamedNavArgument
import com.example.navigationcustomnavhostcontroller.navigation.destinations.CustomNavDestinations
import com.example.navigationcustomnavhostcontroller.navigation.animations.CustomNavAnimations
import com.example.navigationcustomnavhostcontroller.navigation.animations.SlidingAnimations

sealed class Screens(val route: String) {
    data object First : Screens("first")
    data object Second : Screens("second")
    data object Third : Screens("third")

}

object FirstScreenDestination : CustomNavDestinations, CustomNavAnimations by SlidingAnimations {
    override val route = Screens.First.route
    override val arguments: List<NamedNavArgument> = emptyList()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FirstGraphFirstScreen(
    navigateToSecondScreen: () -> Unit,

    ) {
    Column(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Yellow)

        ) {
            Button(onClick = {
                navigateToSecondScreen()
//                navController.navigate(Screens.Second.route)
            }) {
                Text(text = "TO Second SCREEN")

            }


        }
    }
}

object SecondScreenDestination : CustomNavDestinations, CustomNavAnimations by SlidingAnimations {
    override val route = Screens.Second.route
    override val arguments: List<NamedNavArgument> = emptyList()
}


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FirstGraphSecondScreen(navigateToThirdScreens: () -> Unit) {
    Column(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red)

        ) {
            Button(onClick = {
                navigateToThirdScreens()
            }) {
                Text(text = "TO Third SCREEN")

            }


        }
    }

}

object ThirdScreenDestination : CustomNavDestinations, CustomNavAnimations by SlidingAnimations {
    override val route = Screens.Third.route
    override val arguments: List<NamedNavArgument> = emptyList()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FirstGraphThirdScreen(navigateToFirstScreen: () -> Unit) {
    Column(modifier = Modifier) {
        Row(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)) {
            Button(onClick = { navigateToFirstScreen() }) {
                Text(text = "TO First SCREEN")

            }

        }
    }
}
