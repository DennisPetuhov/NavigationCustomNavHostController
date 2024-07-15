package com.example.navigationcustomnavhostcontroller.navigation.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import com.example.navigationcustomnavhostcontroller.navigation.animations.CustomNavAnimations

interface CustomNavDestinations : CustomNavAnimations {
    val route: String
    val arguments: List<NamedNavArgument>
    fun getDeepLinks(): List<NavDeepLink> = listOf()
}