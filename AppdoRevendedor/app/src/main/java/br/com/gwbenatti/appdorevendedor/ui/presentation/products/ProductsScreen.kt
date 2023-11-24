package br.com.gwbenatti.appdorevendedor.ui.presentation.products

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.gwbenatti.appdorevendedor.R
import br.com.gwbenatti.appdorevendedor.domain.model.Family
import br.com.gwbenatti.appdorevendedor.domain.model.Group
import br.com.gwbenatti.appdorevendedor.domain.model.Product
import br.com.gwbenatti.appdorevendedor.ui.presentation.components.productsList
import br.com.gwbenatti.appdorevendedor.ui.theme.AppDoRevendedorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(
    navController: NavController,
) {
    val products = listOf<Product>(
        Product(
            1,
            "Malbec 100ml",
            189.9,
            null,
            Family(1, "Perfumaria"),
            Group(1, "Malbec")
        ),
        Product(
            1,
            "Malbec 100ml",
            189.9,
            null,
            Family(1, "Perfumaria"),
            Group(1, "Malbec")
        ),
        Product(
            1,
            "Malbec 100ml",
            189.9,
            null,
            Family(1, "Perfumaria"),
            Group(1, "Malbec")
        ),
    )

    Scaffold(
        topBar = { ProductsTopBar() },
        bottomBar = { ProductsBottomBar() },
        floatingActionButton = {
            ProductsFAB(
                onClick = {
                    val product = Product()
                    navController.navigate("products/${product.id}")
                }
            )
        },
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LazyColumn {
                productsList(
                    products = products,
                    onProductClick = { product ->
                        navController.navigate("products/${product.id}")
                    }
                )
            }
        }
    }
}

@Composable()
private fun ProductsFAB(
    onClick: () -> Unit,
    imageVector: ImageVector = Icons.Default.Add,
) {
    ExtendedFloatingActionButton(
        onClick = onClick,
    ) {
        Icon(imageVector = imageVector, contentDescription = null)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = stringResource(id = R.string.lbl_new_product))
    }
}

@Composable()
private fun ProductsBottomBar() {
    BottomAppBar {
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Outlined.CheckCircle, contentDescription = null) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.lbl_sales))
            }
        )
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.lbl_products))
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Outlined.Person, contentDescription = null) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.lbl_customers))
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Menu, contentDescription = null) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.lbl_menu))
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable()
private fun ProductsTopBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.lbl_products))
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
        },
    )
}

@Preview()
@Composable()
fun ProductsScreenPreview() {
    val nav = rememberNavController()
    AppDoRevendedorTheme {
        ProductsScreen(nav)
    }
}