package com.example.navigationcustomnavhostcontroller.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NamedNavArgument
import com.example.navigationcustomnavhostcontroller.MainActivity
import com.example.navigationcustomnavhostcontroller.navigation.animations.CustomNavAnimations
import com.example.navigationcustomnavhostcontroller.navigation.animations.SlidingAnimations
import com.example.navigationcustomnavhostcontroller.navigation.destinations.CustomNavDestinations

sealed class ScreensDestinationsMainGraph(val route: String) {
    data object FirstScreen : ScreensDestinationsMainGraph("second_first")
    data object SecondScreen : ScreensDestinationsMainGraph("second_second")
}

object MainGraphFirstScreenDestination : CustomNavDestinations,
    CustomNavAnimations by SlidingAnimations {
    override val route = ScreensDestinationsMainGraph.FirstScreen.route
    override val arguments: List<NamedNavArgument> = emptyList()
}

@Composable
fun MainGraphFirstScreen(
    navigateToSecondScreen: () -> Unit,
) {
    Column(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Cyan)

        ) {
            Text(text = "SecondGraphFirstScreen")
            Button(onClick = { navigateToSecondScreen() }) {
                Text(text = "TO Second SCREEN")
            }
            var leakyObject by remember { mutableStateOf<LeakyClass?>(null) }
            val context = LocalContext.current as MainActivity
            Button(onClick =
            { leakyObject = LeakyClass(context) }) { Text("Create Leak") }
        }
    }
}

object MainGraphSecondScreenDestination : CustomNavDestinations,
    CustomNavAnimations by SlidingAnimations {
    override val route = ScreensDestinationsMainGraph.SecondScreen.route
    override val arguments: List<NamedNavArgument> = emptyList()
}

@Composable
fun MainGraphSecondScreen(navigateToThirdScreens: () -> Unit) {
    Column(modifier = Modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red)

        ) {
            Text(text = "SecondGraphSecondScreen")
            Button(onClick = {
                navigateToThirdScreens()
            }) { Text(text = "TO Third SCREEN") }
        }
    }
}