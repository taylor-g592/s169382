package com.taylorm.s169382.presentation.results

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.taylorm.dissertation.R
import com.taylorm.s169382.presentation.components.StandardToolbar
import com.taylorm.s169382.presentation.domain.models.Results

/*
Composable function to display the search results.
 */

@Composable
fun SearchResultsScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.search_results),
                    fontWeight = FontWeight.Bold
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true,
            navActions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Help,
                        contentDescription = ""
                    )
                }
            }
        )
        SearchResults(
            results = Results(
                name = "Example Name",
                imageUrl = "",
                description = "A vaccine is a biological preparation that provides active acquired immunity to a particular disease."
            )
        )
    }
}