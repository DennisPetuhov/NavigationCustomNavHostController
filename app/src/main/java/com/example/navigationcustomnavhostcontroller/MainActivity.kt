package com.example.navigationcustomnavhostcontroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.navigationcustomnavhostcontroller.navigation.MainScreens
import com.example.navigationcustomnavhostcontroller.navigation.builders.CustomNavHost
import com.example.navigationcustomnavhostcontroller.navigation.builders.firstNavGraph
import com.example.navigationcustomnavhostcontroller.navigation.builders.secondNavGraph
import com.example.navigationcustomnavhostcontroller.navigation.first_graph.FirstScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.rememberCustomNavController
import com.example.navigationcustomnavhostcontroller.ui.theme.NavigationCustomNavHostControllerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationCustomNavHostControllerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyMainScreen()
                }
            }
        }
    }
}

@Composable
private fun MyMainScreen() {
    val navController = rememberNavController()
    val customNavController = rememberCustomNavController(navController)
    Column(modifier = Modifier) {
        Spacer(
            modifier = Modifier
                .padding(100.dp)
                .size(width = 100.dp, height = 100.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(color = Color.Magenta)
        ) {
            Button(onClick = { navController.navigate(MainScreens.FirstNavGraph.route) }) {
                Text(text = "TO first GRAPH")

            }
            Button(onClick = { navController.navigate(MainScreens.SecondNavGraph.route) }) {
                Text(text = "TO second GRAPH")

            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(color = Color.Green)
        ) {
            CustomNavHost(
                navController = navController,
                startDestination = remember { FirstScreenDestination }
            ) {
                secondNavGraph(
                    navigateToDestination = customNavController::navigate,
                    navigateByDeepLink = customNavController::navigate
                )
                firstNavGraph(
                    navigateToDestination = customNavController::navigate,
                    navigateByDeepLink = customNavController::navigate
                )

            }


        }
    }
}