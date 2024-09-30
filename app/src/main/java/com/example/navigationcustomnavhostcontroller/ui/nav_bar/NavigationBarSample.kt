package com.example.navigationcustomnavhostcontroller.ui.nav_bar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.navigationcustomnavhostcontroller.navigation.destinations.CustomNavDestinations
import com.example.navigationcustomnavhostcontroller.navigation.destinations.NavBarFirstScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.NavBarSecondScreenDestination
import com.example.navigationcustomnavhostcontroller.navigation.destinations.NavBarThirdScreenDestination

@Composable
fun NavigationBarSample(
    navigateToScreen: () -> Unit,
    navigateByNavBar: (CustomNavDestinations) -> Unit,
    selectedItem: MutableIntState,
) {


    val myItems = listOf(
        BottomItem(NavBarFirstScreenDestination, "Weather", Icons.Filled.Home, Icons.Outlined.Face,0),
        BottomItem(
            NavBarSecondScreenDestination,
            "Bulletin",
            Icons.Filled.Favorite,
            Icons.Outlined.Notifications,1
        ),
        BottomItem(
            NavBarThirdScreenDestination,
            "Knowledge",
            Icons.Filled.Star,
            Icons.Outlined.AccountBox,2
        )
    )

    AssNavigationBar {
        myItems.forEachIndexed { index, item ->
            AssNavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = item.selectedIcon,
                        contentDescription = item.label,
                    )
                },
                label = { Text(item.label) },
                selected = selectedItem.value == item.index,
                onClick = {
                    selectedItem.intValue = index
                    navigateByNavBar(item.route)
                },
            )
        }
    }
}

@Composable
fun AssNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        contentColor = AssNavigationDefaults.navigationContentColor(),
        tonalElevation = 0.dp,
        content = content,
    )
}

data class BottomItem(
    val route: CustomNavDestinations,
    val label: String,
    val selectedIcon: ImageVector,
    val icon: ImageVector, val index: Int
)

@Composable
fun RowScope.AssNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alwaysShowLabel: Boolean = true,
    icon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit = icon,
    label: @Composable (() -> Unit)? = null,
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = AssNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = AssNavigationDefaults.navigationContentColor(),
            selectedTextColor = AssNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = AssNavigationDefaults.navigationContentColor(),
            indicatorColor = AssNavigationDefaults.navigationIndicatorColor(),
        ),
    )
}

object AssNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}

val items = listOf("Weather", "Bulletin", "Knowledge")
val icons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Star)
val selectedIcons =
    listOf(Icons.Outlined.Home, Icons.Outlined.Face, Icons.Outlined.AccountBox)