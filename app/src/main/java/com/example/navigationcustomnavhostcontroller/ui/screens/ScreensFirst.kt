package com.example.navigationcustomnavhostcontroller.ui.screens

import android.annotation.SuppressLint
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

sealed class ScreensDestinationsFirstGraph(val route: String) {
    data object FirstGraph : ScreensDestinationsFirstGraph("first")
    data object Second : ScreensDestinationsFirstGraph("second")
    data object Third : ScreensDestinationsFirstGraph("third")
}

object AuthGraphFirstScreenDestination : CustomNavDestinations,
    CustomNavAnimations by SlidingAnimations {
    override val route = ScreensDestinationsFirstGraph.FirstGraph.route
    override val arguments: List<NamedNavArgument> = emptyList()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AuthGraphFirstScreen(
    navigateToSecondScreen: () -> Unit,
) {
    Column(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Yellow)
        ) {
            Button(onClick = { navigateToSecondScreen() }) { Text(text = "TO Second SCREEN") }
            var leakyObject by remember { mutableStateOf<LeakyClass?>(null) }
            val context = LocalContext.current as MainActivity
            Button(onClick = { leakyObject = LeakyClass(context) }) { Text("Create Leak") }
        }
    }
}

object AuthGraphSecondScreenDestination : CustomNavDestinations,
    CustomNavAnimations by SlidingAnimations {
    override val route = ScreensDestinationsFirstGraph.Second.route
    override val arguments: List<NamedNavArgument> = emptyList()
}


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun AuthGraphSecondScreen(navigateToThirdScreens: () -> Unit) {
    Column(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red)
        ) {
            Button(onClick = { navigateToThirdScreens() }) { Text(text = "TO Third SCREEN") }
        }
    }
}

object AuthGraphThirdScreenDestination : CustomNavDestinations,
    CustomNavAnimations by SlidingAnimations {
    override val route = ScreensDestinationsFirstGraph.Third.route
    override val arguments: List<NamedNavArgument> = emptyList()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AuthGraphThirdScreen(navigateToFirstScreen: () -> Unit) {
    Column(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue)
        ) {
            Button(onClick = { navigateToFirstScreen() }) { Text(text = "TO First SCREEN") }
        }
    }
}

class LeakyClass(activity: MainActivity) {
    private val reference = activity
}

@Composable
fun LeakyComposable(activity: MainActivity) {
    var leakyObject by remember { mutableStateOf<LeakyClass?>(null) }
    Button(onClick =
    { leakyObject = LeakyClass(activity) }) { Text("Create Leak") }
}