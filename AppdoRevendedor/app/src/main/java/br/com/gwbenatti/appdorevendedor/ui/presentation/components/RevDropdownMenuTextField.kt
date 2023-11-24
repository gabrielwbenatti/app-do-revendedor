package br.com.gwbenatti.appdorevendedor.ui.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RevDropdownMenuTextField(
//    modifier: Modifier = Modifier,
//) {
//    ExposedDropdownMenuBox(
//        expanded = expFamily,
//        onExpandedChange = { expFamily = it }
//    ) {
//        RevTextField(
//            modifier = Modifier
//                .menuAnchor()
//                .fillMaxWidth(),
//            value = txtFamily,
//            label = "Família",
//            readOnly = true,
//            imeAction = ImeAction.Next,
//            onValueChange = { txtFamily = it }
//        )
//        ExposedDropdownMenu(
//            modifier = Modifier.fillMaxWidth(),
//            expanded = expFamily,
//            onDismissRequest = { expFamily = false }
//        ) {
//            DropdownMenuItem(
//                text = { Text(text = "O Boticário") },
//                onClick = {
//                    txtFamily = "O Boticário"
//                    expFamily = false
//                })
//            DropdownMenuItem(
//                text = { Text(text = "Natura") },
//                onClick = {
//                    txtFamily = "Natura"
//                    expFamily = false
//                })
//            DropdownMenuItem(
//                text = { Text(text = "Avon") },
//                onClick = {
//                    txtFamily = "Avon"
//                    expFamily = false
//                })
//        }
//    }
//}