package br.com.gwbenatti.appdorevendedor.ui.presentation.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.gwbenatti.appdorevendedor.ui.presentation.common.components.RevSectionComponents
import br.com.gwbenatti.appdorevendedor.ui.presentation.common.components.RevTextField
import br.com.gwbenatti.appdorevendedor.ui.theme.AppDoRevendedorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    navController: NavController,
    productId: Int,
) {
    val isEditing = (productId != 0)
    var txtName by rememberSaveable { mutableStateOf("") }
    val txtPrice by rememberSaveable { mutableStateOf("R$ 0,00") }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    fun txtPriceChange(txt: String) {
        if (txt.trim().isNotEmpty()) {
            var rawTxt = "" //txt.replace(Regex("\\d"))
        }
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                title = { Text(text = if(isEditing) "Editando produto" else "Novo produto") },
                scrollBehavior = scrollBehavior,
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
    ) { itPadding ->
        Surface(
            modifier = Modifier
                .padding(itPadding)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                RevSectionComponents(
                    title = "Dados do produto"
                ) {
                    RevTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = txtName,
                        onValueChange = { txtName = it },
                        label = "Nome",
                        singleLine = true,
                        imeAction = ImeAction.Next,
                    )
                }

                RevSectionComponents(title = "Valores (R$)") {
                    RevTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = txtPrice,
                        onValueChange = { txtPriceChange(it) },
                        label = "Venda (R$)",
                        singleLine = true,
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Done,
                    )
                }

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { /*TODO*/ },
                ) {
                    Text(text = "Salvar produto")
                }
            }
        }
    }
}
