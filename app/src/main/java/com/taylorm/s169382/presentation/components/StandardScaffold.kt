package com.taylorm.s169382.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.taylorm.dissertation.presentation.domain.models.BottomNavItem
import com.taylorm.dissertation.presentation.theme.util.Screen
import com.taylorm.s169382.presentation.domain.models.BottomNavItem
import com.taylorm.s169382.presentation.theme.util.Screen

/*
Composable function to display the standard scaffold.
 */

@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    showToolbar: Boolean = true,
    toolbarTitle: String? = null,
    showBackArrow: Boolean = true,
    navActions: @Composable RowScope.() -> Unit = {},
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.HomeScreen.route,
            icon = Icons.Default.Home,
            contentDescription = "Home"
        ),
        BottomNavItem(
            route = Screen.SearchResultsScreen.route,
            icon = Icons.Default.Search,
            contentDescription = "Search Results"
        ),
        BottomNavItem(
            route = Screen.FavouritesScreen.route,
            icon = Icons.Default.Favorite,
            contentDescription = "Favourites"
        ),
        BottomNavItem(
            route = Screen.HelpScreen.route,
            icon = Icons.Default.Help,
            contentDescription = "Help"
        ),
    ),
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            if(showBottomBar) {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = MaterialTheme.colors.onPrimary,
                    cutoutShape = CircleShape,
                    elevation = 5.dp
                ) {
                    BottomNavigation {
                        bottomNavItems.forEachIndexed{ i, bottomNavItem ->
                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                selected = bottomNavItem.route == navController.currentDestination?.route,
                            ) {
                                if(navController.currentDestination?.route != bottomNavItem.route) {
                                    navController.navigate(bottomNavItem.route)
                                }
                            }
                        }
                    }
                }
            }
        },
        modifier = modifier
    ) {
        content()
    }
}

