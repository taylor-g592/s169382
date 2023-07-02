package com.taylorm.s169382.presentation.theme.util

/*
Sealed class representing the different screens in the app and their routes.
 */

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object HomeScreen : Screen("home_screen")
    object SearchScreen: Screen("search_screen")
    object SearchResultsScreen: Screen("search_results_screen")
    object HelpScreen: Screen("help_screen")
    object FavouritesScreen: Screen("favourites_screen")
    object ApiResults: Screen("api_results")
}
