package com.taylorm.s169382.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.taylorm.s169382.presentation.theme.util.TestTags

/*
Composable function to display a standard text field.
Used for login and register screens.
 */

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int = 40,
    error: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    showPasswordToggle: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = {
                if(it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.body1
                )
            },
            isError = error != "",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if(!showPasswordToggle && isPasswordToggleDisplayed) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            singleLine = true,
            trailingIcon = {
                if(isPasswordToggleDisplayed) {
                    IconButton(
                        onClick = {
                            onPasswordToggleClick(!showPasswordToggle)
                        },
                        modifier = Modifier
                            .semantics {
                                testTag = TestTags.PASSWORD_TOGGLE
                            }
                    ) {
                        Icon(
                            imageVector = if(showPasswordToggle) {
                                Icons.Filled.VisibilityOff
                            } else {
                                Icons.Filled.Visibility
                            },
                            // Tint is set to primary color (purple) to add contrast to increase readability
                            tint = MaterialTheme.colors.primary,
                            contentDescription = if(showPasswordToggle) {
                                stringResource(id = com.taylorm.dissertation.R.string.password_visible_content_description)
                            } else {
                                stringResource(id = com.taylorm.dissertation.R.string.password_hidden_content_description)
                            }
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    testTag = TestTags.STANDARD_TEXT_FIELD
                }
        )
        if(error.isNotEmpty()) {
            Text(
                text = error,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}