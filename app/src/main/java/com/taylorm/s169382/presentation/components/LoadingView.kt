package com.taylorm.s169382.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.taylorm.dissertation.presentation.ui.theme.DissertationTheme
import com.taylorm.s169382.presentation.ui.theme.DissertationTheme

/*
Composable function to display a loading spinner.
 */

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
@Preview
fun LoadingViewPreview() {
    DissertationTheme {
        LoadingView()
    }
}