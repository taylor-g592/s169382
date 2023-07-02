package com.taylorm.s169382.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
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
import com.taylorm.s169382.presentation.ui.theme.backgroundWhite
import com.taylorm.s169382.presentation.ui.theme.white

/*
Composable function to display the home screen.
 */

@Composable
fun HomeScreen(
    navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        homeViewModel.onEvent(HomeEvents.GetProviders(page = "1", perPageItems = "20"))
    }

    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            StandardToolbar(navController = navController, title = {
                Text(
                    text = stringResource(id = R.string.home_screen),
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
            is HomeUIState.Loading -> {
                LoadingView(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }

            is HomeUIState.ErrorState -> {
                ErrorView(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    error = "Something went wrong"
                )
            }

            is HomeUIState.SuccessState -> {
                MyLazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    (uiState as HomeUIState.SuccessState).providers.providers, homeViewModel
                )

            }
        }
    }

}


@Composable
fun MyLazyColumn(
    modifier: Modifier = Modifier,
    items: List<Provider>,
    homeViewModel: HomeViewModel
) {
    LazyColumn(contentPadding = PaddingValues(8.dp), modifier = modifier) {
        items(items) { item ->
            MyCustomItem(item = item, homeViewModel)
        }
    }
}

@Composable
fun MyCustomItem(item: Provider, homeViewModel: HomeViewModel) {
    var isFavorite by remember { mutableStateOf(item.isFavorite) }
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
            IconButton(
                onClick = { /* Handle favorite/unfavorite button click */
                    if (isFavorite) {
                        homeViewModel.onEvent(HomeEvents.RemoveFromFavorite(item))
                        isFavorite = false
                    } else {
                        homeViewModel.onEvent(HomeEvents.AddToFavorite(item))
                        isFavorite = true
                    }
                }
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = if (isFavorite) "Unfavorite" else "Favorite"
                )
            }
        }
    }
}

@Composable
fun ScreenContent(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 75.dp) // Sets padding for the box that wraps the entire screen
            .verticalScroll(rememberScrollState()) // Might not be required?
            .background(backgroundWhite) // Set in theme.kt for consistency across app
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(top = 32.dp)
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 30.dp)
        ) {
            Box(
                Modifier
                    .fillMaxWidth(0.9f) // Width takes up 90% of screen width
                    .height(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(white)
                    .then(Modifier.shadow(4.dp))
                    .align(Alignment.CenterHorizontally)
            ) {
                Row(Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(id = R.string.welcome),
                        style = MaterialTheme.typography.body1
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                Modifier
                    .fillMaxWidth(0.8f)
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(white)
                    .then(
                        Modifier.shadow(4.dp)
                    )
                    .align(Alignment.CenterHorizontally)
            ) {
                Row(Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(R.drawable.vaccine),
                        contentDescription = null,
                        Modifier
                            .size(64.dp)
                            .padding(end = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text("Column 1 Text")
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                Modifier
                    .fillMaxWidth(0.8f)
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(white)
                    .then(Modifier.shadow(4.dp))
                    .align(Alignment.CenterHorizontally)
            ) {
                Row(Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(R.drawable.vaccine),
                        contentDescription = null,
                        Modifier
                            .size(64.dp)
                            .padding(end = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text("Column 3 Text")
                }
            }
        }
    }
}