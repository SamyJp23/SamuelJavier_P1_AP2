package edu.ucne.samueljavier_p1_ap2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import edu.ucne.samueljavier_p1_ap2.presentation.entidad.EntidadViewModel
import edu.ucne.samueljavier_p1_ap2.presentation.navigation.AppNavHost
import edu.ucne.samueljavier_p1_ap2.ui.theme.SamuelJavier_P1_AP2Theme
import javax.inject.Inject


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            SamuelJavier_P1_AP2Theme {
     val navHost = rememberNavController()
                AppNavHost(navHost)
            }
        }
    }


}


