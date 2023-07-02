package com.taylorm.s169382.presentation.domain.models

import androidx.compose.ui.graphics.vector.ImageVector

/*
Model class for the bottom navigation bar items.
 */

class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val contentDescription: String? = null,
) {
}