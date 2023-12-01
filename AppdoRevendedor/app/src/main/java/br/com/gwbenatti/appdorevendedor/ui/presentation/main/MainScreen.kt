package br.com.gwbenatti.appdorevendedor.ui.presentation.main


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.gwbenatti.appdorevendedor.R
import br.com.gwbenatti.appdorevendedor.domain.model.Product
import br.com.gwbenatti.appdorevendedor.ui.presentation.products.ProductsScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
) {
    var selectedIndex = 1
    fun onDestinationClick(index: Int) {
        selectedIndex = index;
    }

    Scaffold(
        bottomBar = {
            MainBottomBar(
                selectedIndex = selectedIndex,
            )
        },
        floatingActionButton = {
            if (selectedIndex == 1) {
                ProductsFAB(onClick = {
                    val product = Product()
                    navController.navigate("products/${product.id}")
                })
            }
        }
    ) { paddingValues ->
        when {
            selectedIndex == 1 -> {
                ProductsScreen(navController = navController)
            }
        }
    }
}

@Composable
private fun MainBottomBar(
    selectedIndex: Int,
    onDestinationClick: () -> Unit = {},
) {
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