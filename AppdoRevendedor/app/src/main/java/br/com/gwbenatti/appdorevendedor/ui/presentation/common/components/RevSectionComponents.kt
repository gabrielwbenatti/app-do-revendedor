package br.com.gwbenatti.appdorevendedor.ui.presentation.common.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RevSectionComponents (
    modifier: Modifier = Modifier,
    title: String,
    content: @Composable () -> Unit
) {
    Column (
        modifier = modifier
    ) {
        Text(text = title)
        Spacer(modifier = Modifier.height(8.dp))
        content()
        Spacer(modifier = Modifier.height(16.dp))
    }
}