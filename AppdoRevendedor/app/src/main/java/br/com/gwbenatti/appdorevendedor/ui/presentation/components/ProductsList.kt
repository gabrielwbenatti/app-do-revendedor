package br.com.gwbenatti.appdorevendedor.ui.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import br.com.gwbenatti.appdorevendedor.domain.model.Product


@OptIn(ExperimentalMaterial3Api::class)
fun LazyListScope.productsList(
    products: List<Product> = emptyList()
) {
    if (products.isEmpty()) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    "Nenhum produto cadastrado!\n" +
                            "Clique em \"+\" para cadastrar um novo produto."
                )
            }
        }
    }

    items(products) { product ->
        ListItem(
            modifier = Modifier.clickable { },
            headlineContent = { Text(text = product.name) },
            supportingContent = { Text(text = "${product.family.name} > ${product.group.name}") },
            trailingContent = {
                if (product.promotionalSalePrice != null) {
                    Column {
                        Text(
                            text = "R\$ " + product.salePrice.toString(),
                            textDecoration = TextDecoration.LineThrough,
                        )
                        Text(text = "R\$ " + product.promotionalSalePrice.toString())
                    }
                } else {
                    Text(text = "R\$ " + product.salePrice.toString())
                }
            }
        )
    }

    if (products.isNotEmpty()) {
        item {
            Spacer(Modifier.height(72.dp))
        }
    }
}
