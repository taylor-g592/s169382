package com.taylorm.s169382.presentation.results

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.taylorm.dissertation.R
import com.taylorm.s169382.presentation.domain.models.Results
import com.taylorm.s169382.presentation.ui.theme.SpaceMedium
import com.taylorm.s169382.presentation.ui.theme.SpaceSmall
import com.taylorm.s169382.presentation.ui.theme.TextBlack
import com.taylorm.s169382.presentation.ui.theme.backgroundWhite
import com.taylorm.s169382.presentation.util.Constants

/*
Composable function to display the search results.
 */

@Composable
fun SearchResults(
    results: Results
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SpaceMedium)
            .background(backgroundWhite)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .shadow(5.dp)
                .background(backgroundWhite)
        ) {
            Image(
                painterResource(id = R.drawable.vaccine),
                contentDescription = "Example image"
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceMedium)
                    .background(backgroundWhite)
            ) {
                ActionRow(
                    name = "Example Name",
                    modifier = Modifier.fillMaxWidth(),
                    onLikeClick = { isLiked ->

                    },
                    onShareClick = {

                    },
                    onNameClick = { name ->

                    }
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                Text(
                    text = buildAnnotatedString {
                        append(results.description)
                        withStyle(SpanStyle(
                            color = TextBlack,
                        )) {
                            append(
                                LocalContext.current.getString(
                                    R.string.read_more
                                )
                            )
                        }
                    },
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = Constants.MAX_POST_DESCRIPTION_LINES
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
        }
    }
}

@Composable
fun EngagementButtons(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    iconSize: Dp = 30.dp,
    onLikeClick: (Boolean) -> Unit = {},
    onShareClick: () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(
            onClick = {
                onLikeClick(!isLiked)
            },
            modifier = Modifier.size(iconSize)
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = if (isLiked) {
                    Color.Red
                } else {
                    TextBlack
                },
                contentDescription = if(isLiked) {
                    stringResource(id = R.string.unlike)
                } else {
                    stringResource(id = R.string.like)
                }
            )
        }
        Spacer(modifier = Modifier.width(SpaceMedium))
        IconButton(
            onClick = {
                onShareClick()
            },
            modifier = Modifier.size(iconSize),
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(id = R.string.share)
            )
        }
    }
}

@Composable
fun ActionRow (
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onShareClick: () -> Unit = {},
    name: String,
    onNameClick: (String) -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
    ) {
        Text(
            text = name,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onPrimary
            ),
            modifier = Modifier
                .clickable {
                    onNameClick(name)
                }
        )
        EngagementButtons(
            isLiked = isLiked,
            onLikeClick = onLikeClick,
            onShareClick = onShareClick
        )
    }
}