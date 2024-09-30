package com.example.navigationcustomnavhostcontroller.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.navigationcustomnavhostcontroller.navigation.destinations.CustomNavDestinations
import com.example.navigationcustomnavhostcontroller.ui.nav_bar.NavigationBarSample

@Composable
fun NavBarFirstScreen(
    modifier: Modifier = Modifier,
    navigateToSecondScreen: () -> Unit,
    navigateByNavBar: (CustomNavDestinations) -> Unit,
    selectedItem: MutableIntState,

    ) {
    Scaffold(bottomBar = {
        NavigationBarSample(
            navigateToSecondScreen,
            navigateByNavBar = navigateByNavBar,selectedItem = selectedItem
        )
    }) { paddingValuues ->


        Column(modifier = Modifier) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Cyan)

            ) {
                Text(text = "NavBarFirstScreen")
                Button(onClick = { navigateToSecondScreen() }) {
                    Text(text = "TO Second SCREEN")
                }
            }
        }
    }
}

@Composable
fun NavBarSecondScreen(
    navigateToThirdScreens: () -> Unit,
    navigateByNavBar: (CustomNavDestinations) -> Unit,
    selectedItem:MutableIntState,
) {
    Scaffold(bottomBar = {
        NavigationBarSample(
            navigateToThirdScreens,
            navigateByNavBar = navigateByNavBar,selectedItem = selectedItem)
    }) { paddingValuues ->
        Column(modifier = Modifier) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Red)

            ) {
                Text(text = "NavBarSecondScreen")
                Button(onClick = {
                    navigateToThirdScreens()
                }) { Text(text = "TO Third SCREEN") }
            }
        }
    }
}

@Composable
fun NavBarThirdScreen(
    navigateToAuth: () -> Unit,
    navigateByNavBar: (CustomNavDestinations) -> Unit,
    selectedItem:MutableIntState,
) {
    Scaffold(bottomBar = {
        NavigationBarSample(
            navigateToAuth,
            navigateByNavBar = navigateByNavBar,selectedItem = selectedItem)
    }) { paddingValuues ->
        Column(modifier = Modifier) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Magenta)
            ) {
                Text(text = "NavBarThirdScreen")
                Button(onClick = { navigateToAuth() }) { Text(text = "navigateToAuth") }
            }
        }
    }
}