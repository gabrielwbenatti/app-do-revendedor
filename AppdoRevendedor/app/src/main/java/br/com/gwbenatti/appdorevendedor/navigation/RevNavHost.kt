package br.com.gwbenatti.appdorevendedor.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun RevNavHost (
    navController: NavHostController = rememberNavController(),
    startDestination: String = "",
) {
    NavHost(
        navController = navController,
        startDestination =  startDestination
    ) {

    }
}