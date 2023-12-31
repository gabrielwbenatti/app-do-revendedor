package br.com.gwbenatti.appdorevendedor.ui.presentation.products

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.gwbenatti.appdorevendedor.R
import br.com.gwbenatti.appdorevendedor.domain.model.Product
import br.com.gwbenatti.appdorevendedor.ui.presentation.components.RevDropdownMenuTextField
import br.com.gwbenatti.appdorevendedor.ui.presentation.components.RevScaffold
import br.com.gwbenatti.appdorevendedor.ui.presentation.components.RevSectionComponents
import br.com.gwbenatti.appdorevendedor.ui.presentation.components.RevSwitch
import br.com.gwbenatti.appdorevendedor.ui.presentation.components.RevTextField
import br.com.gwbenatti.appdorevendedor.ui.theme.AppDoRevendedorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    navController: NavController,
    product: Product,
) {
    val isEditing = (product.id != 0)
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    val tabs = listOf(
        stringResource(id = R.string.lbl_register),
        stringResource(id = R.string.lbl_special_offer),
        stringResource(id = R.string.lbl_history)
    )
    val selectedTabIndex = rememberSaveable { mutableIntStateOf(0) }

    RevScaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Text(
                            text = if (isEditing) stringResource(id = R.string.lbl_editing_product) else stringResource(
                                id = R.string.lbl_new_product
                            )
                        )
                    },
                    scrollBehavior = scrollBehavior,
                    navigationIcon = {
                        IconButton(
                            onClick = { navController.popBackStack() }
                        ) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(),
                )
                if (isEditing) {
                    TabRow(
                        selectedTabIndex = selectedTabIndex.intValue,
                        indicator = { tabPositions ->
                            if (selectedTabIndex.intValue < tabPositions.size) {
                                TabRowDefaults.Indicator(
                                    modifier = Modifier
                                        .tabIndicatorOffset(tabPositions[selectedTabIndex.intValue]),
                                )
                            }
                        }
                    ) {
                        tabs.forEachIndexed { index, tab ->
                            Tab(
                                selected = (index == selectedTabIndex.intValue),
                                onClick = { selectedTabIndex.intValue = index },
                                text = { Text(text = tab) })
                        }
                    }
                }
            }
        },
    ) {
        when (selectedTabIndex.intValue) {
            0 -> RegisterTab(navController = navController, product = product)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegisterTab(
    navController: NavController,
    product: Product,
) {
    var txtCatalogReference by rememberSaveable { mutableStateOf("") }
    var txtName by rememberSaveable { mutableStateOf(product.name) }
    var expFamily by rememberSaveable { mutableStateOf(false) }
    var expCategory by rememberSaveable { mutableStateOf(false) }
    var txtFamily by rememberSaveable { mutableStateOf("") }
    var txtCategory by rememberSaveable { mutableStateOf("") }
    var swActive by rememberSaveable { mutableStateOf(true) }
    var txtSalePrice by rememberSaveable { mutableStateOf("") }
    var txtCostPrice by rememberSaveable { mutableStateOf("") }

    val brands = listOf("O Boticário", "Natura", "Avon")
    val categories = listOf("Perfumaria", "Corpo e Banho", "Infantil")

    RevSectionComponents(title = stringResource(id = R.string.lbl_product_infos)) {
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
            label = stringResource(id = R.string.lbl_name),
            singleLine = true,
            imeAction = ImeAction.Next,
            keyboardCapitalization = KeyboardCapitalization.Words,
        )
        RevDropdownMenuTextField(
            modifier = Modifier.fillMaxWidth(),
            value = txtCategory,
            label = stringResource(id = R.string.lbl_category),
            expanded = expCategory,
            items = categories,
            onDismissRequest = { expCategory = false },
            onValueChange = { txtCategory = it },
            onExpandedChange = { expCategory = it }
        )
        RevDropdownMenuTextField(
            modifier = Modifier.fillMaxWidth(),
            value = txtFamily,
            label = stringResource(id = R.string.lbl_brand),
            expanded = expFamily,
            items = brands,
            onDismissRequest = { expFamily = false },
            onValueChange = { txtFamily = it },
            onExpandedChange = { expFamily = it }
        )
        RevSwitch(
            headlineText = stringResource(id = R.string.lbl_active),
            checked = swActive,
            onCheckedChange = { swActive = it },
        )
    }

    RevSectionComponents(title = stringResource(id = R.string.lbl_prices)) {
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

@Preview
@Composable
fun NewProductDetailScreenPreview() {
    AppDoRevendedorTheme {
        ProductDetailScreen(
            navController = rememberNavController(),
            product = Product()
        )
    }
}

@Preview
@Composable
fun EditProductDetailScreenPreview() {
    AppDoRevendedorTheme {
        ProductDetailScreen(
            navController = rememberNavController(),
            product = Product(1)
        )
    }
}