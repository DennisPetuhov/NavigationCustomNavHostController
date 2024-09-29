package com.example.navigationcustomnavhostcontroller.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

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
        }
    }
}

@Composable
fun AuthGraphSecondScreen(navigateToThirdScreens: () -> Unit) {
    Column(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red)
        ) { Button(onClick = { navigateToThirdScreens() }) { Text(text = "TO Third SCREEN") } }
    }
}

@Composable
fun AuthGraphThirdScreen(navigateToBottomNavigation: () -> Unit) {
    Column(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue)
        ) { Button(onClick = { navigateToBottomNavigation() }) { Text(text = "TO First SCREEN") } }
    }
}