package com.taylorm.s169382.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.taylorm.dissertation.R

/*
Composable function to display the logo.
 */

@Composable
fun Logo(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(top = 16.dp)
    ) {
        Image(
            painterResource(id = R.drawable.logo2),
            contentDescription = "logo",
            modifier = Modifier.size(80.dp)
        )
    }
}