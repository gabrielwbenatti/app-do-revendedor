package br.com.gwbenatti.appdorevendedor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.gwbenatti.appdorevendedor.navigation.RevNavHost
import br.com.gwbenatti.appdorevendedor.ui.presentation.products.ProductDetailScreen
import br.com.gwbenatti.appdorevendedor.ui.presentation.products.ProductsScreen
import br.com.gwbenatti.appdorevendedor.ui.theme.AppDoRevendedorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppDoRevendedorTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "products",
                ) {

                    composable(route = "products") { ProductsScreen(navController) }
                    composable(
                        route = "products/{productId}",
                        arguments = listOf(navArgument("productId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        backStackEntry.arguments?.getInt("productId", 0)?.let {
                            ProductDetailScreen(
                                navController,
                                productId = it
                            )
                        }
                    }
                }
            }
        }
    }
}
