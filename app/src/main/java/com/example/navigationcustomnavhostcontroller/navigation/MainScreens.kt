package com.example.navigationcustomnavhostcontroller.navigation

sealed class MainScreens(val route: String) {
    data object FirstNavGraph : MainScreens("first_nav_graph")
    data object SecondNavGraph : MainScreens("second_nav_graph")
}