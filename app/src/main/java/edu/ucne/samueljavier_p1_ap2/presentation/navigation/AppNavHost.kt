package edu.ucne.samueljavier_p1_ap2.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.ucne.samueljavier_p1_ap2.presentation.home.Home

@Composable
fun AppNavHost(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home
    ){
        composable<Screen.Home>{
            Home(
                goToSistema = {
                    navHostController.navigate(Screen.SistemaListScreen)
                }
            )
        }
    }
}