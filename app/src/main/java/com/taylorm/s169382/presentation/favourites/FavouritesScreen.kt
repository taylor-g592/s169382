package com.taylorm.s169382.presentation.favourites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.taylorm.dissertation.R
import com.taylorm.dissertation.data.api.entities.Provider
import com.taylorm.s169382.presentation.components.ErrorView
import com.taylorm.s169382.presentation.components.LoadingView
import com.taylorm.s169382.presentation.components.StandardToolbar

/*
Composable function to display the favourites screen.
 */

@Composable
fun FavouritesScreen(
    navController: NavController, favoriteViewModel: FavouriteViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = Unit) {
        favoriteViewModel.onEvent(FavoriteEvents.GetFavoriteProviders)
    }

    val uiState by favoriteViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            StandardToolbar(navController = navController, title = {
                Text(
                    text = stringResource(id = R.string.favorites),
                    fontWeight = FontWeight.Bold,
                )
            }, modifier = Modifier.fillMaxWidth(), showBackArrow = false, navActions = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Home, contentDescription = ""
                    )
                }
            })
        }

    ) { paddingValues ->


        when (uiState) {
            is FavoriteUIState.Loading -> {
                LoadingView(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }

            is FavoriteUIState.ErrorState -> {
                ErrorView(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    error = "Something went wrong"
                )
            }

            is FavoriteUIState.SuccessState -> {
                MyLazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    (uiState as FavoriteUIState.SuccessState).providers, favoriteViewModel
                )
                //ScreenContent(modifier = Modifier.fillMaxSize())
            }

            else -> {}
        }
    }

}


@Composable
fun MyLazyColumn(
    modifier: Modifier = Modifier,
    items: List<Provider>,
    favoriteViewModel: FavouriteViewModel
) {
    LazyColumn(contentPadding = PaddingValues(8.dp), modifier = modifier) {
        items(items) { item ->
            MyCustomItem(item = item, favoriteViewModel)
        }
    }
}

@Composable
fun MyCustomItem(item: Provider, favoriteViewModel: FavouriteViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.providerId,
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
                Text(text = item.providerName, style = TextStyle(fontSize = 14.sp))
            }

        }
    }
}