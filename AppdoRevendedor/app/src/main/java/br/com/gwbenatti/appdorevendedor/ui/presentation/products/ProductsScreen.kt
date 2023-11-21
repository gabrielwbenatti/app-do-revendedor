package br.com.gwbenatti.appdorevendedor.ui.presentation.products

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.gwbenatti.appdorevendedor.domain.model.Product
import br.com.gwbenatti.appdorevendedor.ui.presentation.components.productsList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(
    navController: NavController
) {
    Scaffold(
        topBar = { AppTopBar() },
        bottomBar = { AppBottomBar() },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Novo Produto") },
                icon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
                onClick = {
                    navController.navigate("products/0")
                }
            )
        },
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            productsList(
                products = listOf(
                    Product(1, "teste", 55.9, null),
                    Product(2, "teste", 55.9, 44.9),
                )
            )
        }
    }
}


@Composable
private fun AppBottomBar() {
    BottomAppBar {
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Outlined.CheckCircle, contentDescription = null) },
            alwaysShowLabel = true,
            label = {
                Text(text = "Vendas")
            }
        )
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null) },
            alwaysShowLabel = true,
            label = {
                Text(text = "Produtos")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Outlined.Person, contentDescription = null) },
            alwaysShowLabel = true,
            label = {
                Text(text = "Clientes")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Menu, contentDescription = null) },
            alwaysShowLabel = true,
            label = {
                Text(text = "Menu")
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppTopBar() {
    TopAppBar(
        title = {
            Text(text = "Produtos")
        },
        actions = {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            }
        }
    )
}