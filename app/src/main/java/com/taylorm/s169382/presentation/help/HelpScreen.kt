package com.taylorm.s169382.presentation.help

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.taylorm.dissertation.data.api.entities.GetProviderResponse
import com.taylorm.s169382.presentation.ui.theme.SpaceMedium
import com.taylorm.s169382.presentation.ui.theme.backgroundWhite


//@Composable
//fun HelpScreen(navController: NavController) {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(text = "Help Screen")
//    }
//}


@Composable
fun HelpScreen(navController: NavController, getProviderResponse: GetProviderResponse? = null) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundWhite)
            .padding(SpaceMedium),
    ) {
        Text(text = "Brand ID: ${getProviderResponse?.brandId ?: ""}")
    }
}