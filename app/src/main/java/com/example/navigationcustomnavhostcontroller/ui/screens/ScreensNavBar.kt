package com.example.navigationcustomnavhostcontroller.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.navigationcustomnavhostcontroller.navigation.builders.MainBottomNavHost
import com.example.navigationcustomnavhostcontroller.navigation.builders.rememberCustomNavController
import com.example.navigationcustomnavhostcontroller.ui.nav_bar.NavigationBarSample

@Composable
fun BottomBarScreen() {
    val navController = rememberNavController()
    val customNavController = rememberCustomNavController(navController)
    Scaffold(bottomBar = { NavigationBarSample() }) { paddingValuues ->
        MainBottomNavHost(
            customNavController = customNavController
        )
    }
}


@Composable
fun BottomGraphFirstScreen(modifier: Modifier = Modifier, navigateToSecondScreen: () -> Unit) {
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
        }
    }
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