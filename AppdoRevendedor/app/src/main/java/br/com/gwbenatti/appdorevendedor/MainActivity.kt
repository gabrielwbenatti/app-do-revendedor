package br.com.gwbenatti.appdorevendedor

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.gwbenatti.appdorevendedor.domain.model.Product
import br.com.gwbenatti.appdorevendedor.ui.presentation.main.MainScreen
import br.com.gwbenatti.appdorevendedor.ui.presentation.products.ProductDetailScreen
import br.com.gwbenatti.appdorevendedor.ui.presentation.products.ProductsScreen
import br.com.gwbenatti.appdorevendedor.ui.theme.AppDoRevendedorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        window.isNavigationBarContrastEnforced = false

        super.onCreate(savedInstanceState)

        setContent {
            AppDoRevendedorTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "mainScreen",
                ) {
                    composable(route = "mainScreen") { MainScreen(navController = navController) }
//                    composable(route = "products") { ProductsScreen(navController) }
                    composable(
                        route = "products/{productId}",
                        arguments = listOf(navArgument("productId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        backStackEntry.arguments?.getInt("productId", 0)?.let { productId ->
                            val product = if (productId == 0) {
                                Product()
                            } else {
                                Product(
                                    productId,
                                    name = "Malbec 100ml",
                                    salePrice = 189.9,
                                )
                            }

                            ProductDetailScreen(
                                navController = navController,
                                product = product,
                            )
                        }
                    }
                }
            }
        }
    }
}
