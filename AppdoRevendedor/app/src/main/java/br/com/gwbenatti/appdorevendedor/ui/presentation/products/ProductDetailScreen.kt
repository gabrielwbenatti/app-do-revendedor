package br.com.gwbenatti.appdorevendedor.ui.presentation.products

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.gwbenatti.appdorevendedor.R
import br.com.gwbenatti.appdorevendedor.ui.presentation.components.RevSectionComponents
import br.com.gwbenatti.appdorevendedor.ui.presentation.components.RevSwitch
import br.com.gwbenatti.appdorevendedor.ui.presentation.components.RevTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    navController: NavController,
    productId: Int,
) {
    val isEditing = (productId != 0)
    var txtCatalogReference by rememberSaveable { mutableStateOf("") }
    var txtName by rememberSaveable { mutableStateOf("") }
    var swActive by rememberSaveable { mutableStateOf(true) }
    var txtSalePrice by rememberSaveable { mutableStateOf("") }
    var txtCostPrice by rememberSaveable { mutableStateOf("") }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                title = { Text(text = if (isEditing) "Editando produto" else stringResource(id = R.string.lbl_new_product)) },
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
                        value = txtCatalogReference,
                        onValueChange = { txtCatalogReference = it },
                        label = "Referência Catálogo",
                        singleLine = true,
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number,
                    )
                    RevTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = txtName,
                        onValueChange = { txtName = it },
                        label = "Nome",
                        singleLine = true,
                        imeAction = ImeAction.Next,
                    )
                    RevSwitch(
                        headlineText = "Ativo",
                        checked = swActive,
                        onCheckedChange = { swActive = it },
                    )
                }

                RevSectionComponents(title = "Valores (R$)") {
                    RevTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = txtSalePrice,
                        onValueChange = { txtSalePrice = it },
                        label = "Venda (R$)",
                        singleLine = true,
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Next,
                    )
                    RevTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = txtCostPrice,
                        onValueChange = { txtCostPrice = it },
                        label = "Custo (R$)",
                        singleLine = true,
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Done,
                    )
                }

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { navController.popBackStack() },
                ) {
                    Text(text = stringResource(id = R.string.lbl_save_product))
                }
            }
        }
    }
}
