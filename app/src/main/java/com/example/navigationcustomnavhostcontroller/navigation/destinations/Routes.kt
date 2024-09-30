package com.example.navigationcustomnavhostcontroller.navigation.destinations

import androidx.navigation.NamedNavArgument
import com.example.navigationcustomnavhostcontroller.navigation.animations.CustomNavAnimations
import com.example.navigationcustomnavhostcontroller.navigation.animations.SlidingAnimations

object NavBarSecondScreenDestination : CustomNavDestinations,
    CustomNavAnimations by SlidingAnimations {
    override val route = ScreensDestinationsBottomBarGraph.SecondScreen.route
    override val arguments: List<NamedNavArgument> = emptyList()
}

object NavBarFirstScreenDestination : CustomNavDestinations,
    CustomNavAnimations by SlidingAnimations {
    override val route = ScreensDestinationsBottomBarGraph.FirstScreen.route
    override val arguments: List<NamedNavArgument> = emptyList()
}
object NavBarThirdScreenDestination : CustomNavDestinations,
    CustomNavAnimations by SlidingAnimations {
    override val route = ScreensDestinationsBottomBarGraph.ThirdScreen.route
    override val arguments: List<NamedNavArgument> = emptyList()
}


sealed class ScreensDestinationsBottomBarGraph(val route: String) {
    data object FirstScreen : ScreensDestinationsBottomBarGraph("first_nav_bar")
    data object SecondScreen : ScreensDestinationsBottomBarGraph("second_nav_bar")
    data object ThirdScreen : ScreensDestinationsBottomBarGraph("third_nav_bar")
}


object AuthGraphSecondScreenDestination : CustomNavDestinations,
    CustomNavAnimations by SlidingAnimations {
    override val route = ScreensAuthGraph.Second.route
    override val arguments: List<NamedNavArgument> = emptyList()
}

sealed class ScreensAuthGraph(val route: String) {
    data object First : ScreensAuthGraph("first")
    data object Second : ScreensAuthGraph("second")
    data object Third : ScreensAuthGraph("third")
}

object AuthGraphFirstScreenDestination : CustomNavDestinations,
    CustomNavAnimations by SlidingAnimations {
    override val route = ScreensAuthGraph.First.route
    override val arguments: List<NamedNavArgument> = emptyList()
}


object AuthGraphThirdScreenDestination : CustomNavDestinations,
    CustomNavAnimations by SlidingAnimations {
    override val route = ScreensAuthGraph.Third.route
    override val arguments: List<NamedNavArgument> = emptyList()
}