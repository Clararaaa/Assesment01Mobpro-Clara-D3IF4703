package com.clara0007.yummyfood.screen

import android.content.res.Configuration
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.clara0007.yummyfood.ui.theme.YummyFoodTheme
import com.clara0007.yummyfood.R

@Composable
fun DisplayAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit
) {
    AlertDialog(
        text = { Text(text = stringResource(R.string.pesan_exit)) },
        confirmButton = {
            TextButton(onClick = { onConfirmation()}) {
                Text(text = stringResource(R.string.tombol_iya))
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissRequest()}) {
                Text(text = stringResource(R.string.tombol_batal))
            }
        },
        onDismissRequest = {onDismissRequest()}
    )
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DialogPreview() {
    YummyFoodTheme {
        DisplayAlertDialog(
            onDismissRequest = {},
            onConfirmation = {}
        )
    }
}