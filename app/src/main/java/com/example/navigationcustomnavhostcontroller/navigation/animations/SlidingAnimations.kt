package com.example.navigationcustomnavhostcontroller.navigation.animations

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavBackStackEntry

object SlidingAnimations : CustomNavAnimations {
    override val enterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition =
        { slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start) }
    override val exitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition =
        { slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start) }
    override val popEnterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition =
        { slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.End) }
    override val popExitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition =
        { slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End) }
}