package edu.ucne.samueljavier_p1_ap2.presentation.navigation

import SistemaScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import edu.ucne.samueljavier_p1_ap2.presentation.entidad.SistemaListScreen
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
        composable<Screen.SistemaListScreen> {
            SistemaListScreen(
                createSistema = { navHostController.navigate(Screen.SistemaScreen(0)) },
                goToMenu = { navHostController.navigateUp() },
                goToSistema = { sistemaId ->
                    navHostController.navigate(Screen.SistemaScreen(sistemaId = sistemaId))
                }
            )
        }
        composable<Screen.SistemaScreen> {
            val sistemaId = it.toRoute<Screen.SistemaScreen>().sistemaId
            SistemaScreen(
                sistemaId = sistemaId,
                goBackToList = {navHostController.navigateUp()}

            )
        }

    }
}