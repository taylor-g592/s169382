package com.taylorm.s169382.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.taylorm.s169382.presentation.theme.util.Screen


@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.SearchResultsScreen.route) {
            SearchResultsScreen(navController = navController)
        }
        composable(Screen.FavouritesScreen.route) {
            FavouritesScreen(navController = navController)
        }
        composable(Screen.HelpScreen.route) {
            HelpScreen(navController = navController)
        }
//        composable(Screen.ApiResults.route) {
//            ApiResults(navController = navController)
//        }
    }
}