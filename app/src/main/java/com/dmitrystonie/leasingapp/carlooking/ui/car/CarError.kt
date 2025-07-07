package com.dmitrystonie.leasingapp.carlooking.ui.car

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dmitrystonie.leasingapp.R


@Composable
fun CarError(onRetry: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = stringResource(R.string.loading_error_title)) },
        text = { Text(text = stringResource(R.string.loading_error_text)) },
        confirmButton = {
            Button(onClick = onRetry) {
                Text(text = stringResource(id = R.string.loading_error_button_text))
            }
        },
        modifier = Modifier,
    )
}