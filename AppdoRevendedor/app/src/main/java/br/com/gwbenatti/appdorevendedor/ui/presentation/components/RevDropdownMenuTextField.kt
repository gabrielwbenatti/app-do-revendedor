package br.com.gwbenatti.appdorevendedor.ui.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RevDropdownMenuTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    imeAction: ImeAction = ImeAction.Next,
    items: List<String>,
    expanded: Boolean = false,
    onDismissRequest: () -> Unit,
    onExpandedChange: (Boolean) -> Unit,
    onValueChange: (String) -> Unit,
) {
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = onExpandedChange
    ) {
        RevTextField(
            modifier = modifier
                .menuAnchor(),
            value = value,
            label = label,
            imeAction = imeAction,
            onValueChange = onValueChange
        )
        ExposedDropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = onDismissRequest,
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        onValueChange(item)
                        onDismissRequest()
                    }
                )
            }
        }
    }
}