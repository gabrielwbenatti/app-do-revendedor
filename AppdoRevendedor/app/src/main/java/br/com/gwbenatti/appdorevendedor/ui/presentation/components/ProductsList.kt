package br.com.gwbenatti.appdorevendedor.ui.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.gwbenatti.appdorevendedor.domain.model.Product


fun LazyListScope.productsList(
    products: List<Product>
) {
    if (products.isEmpty()) {
        item {
            Column {
                Text("Nenhum produto cadastrado!")
                Text("Clique em \"+\" para cadastrar um novo produto.")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductItem(
    modifier: Modifier = Modifier,
    product: Product
) {
    ListItem(
        headlineText = { Text(text =  product.name ) }
    )
}