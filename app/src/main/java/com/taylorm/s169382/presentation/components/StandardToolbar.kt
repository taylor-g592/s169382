package com.taylorm.s169382.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.taylorm.dissertation.R

/*
Composable function to display the standard toolbar.
 */

@Composable
fun StandardToolbar(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBackArrow: Boolean = false,
    navActions: @Composable RowScope.() -> Unit = {},
    title: @Composable () -> Unit = {}
) {
//    Box(modifier = Modifier.fillMaxSize()) {
//        Image(
//            painter = painterResource(id = R.drawable.logo2),
//            contentDescription = "Logo",
//            modifier = Modifier.align(Alignment.TopCenter)
//        )
//    }
    TopAppBar(
        title = title,
        navigationIcon = if(showBackArrow) {
            {
                IconButton(
                    onClick = {
                    navController.navigateUp()
                },
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.back),
                    )
                }
            }
        } else null,
        actions = navActions,
        backgroundColor = MaterialTheme.colors.surface, // Sets the colour of the top bar
        elevation = 5.dp
    )
}