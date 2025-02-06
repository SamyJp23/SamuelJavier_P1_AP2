package edu.ucne.samueljavier_p1_ap2.presentation.entidad


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import edu.ucne.samueljavier_p1_ap2.data.entity.SistemaEntity
import edu.ucne.samueljavier_p1_ap2.presentation.entidad.SistemaUiState
import edu.ucne.samueljavier_p1_ap2.presentation.entidad.SistemaViewModel


@Composable
fun SistemaListScreen(
    viewModel: SistemaViewModel = hiltViewModel(),
    createSistema: () -> Unit,
    goToMenu: () -> Unit,
    goToSistema: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    SistemaListBodyScreen(
        uiState,
        createSistema,
        goToMenu,
        goToSistema
    )
}

@Composable
fun SistemaListBodyScreen(
    uiState: SistemaUiState,
    createSistema: () -> Unit,
    goToMenu: () -> Unit,
    goToSistema: (Int) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    SistemaHeaderRow()
                }
                items(uiState.sistemas) {
                    EntidadRow(it, goToSistema)
                }
            }
        }

        FloatingActionButton(
            onClick = { createSistema() },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = Color.Gray,
            contentColor = Color.White

        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Crear Sistema"
            )
        }
    }
}


@Composable
private fun SistemaHeaderRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.Gray)
            .padding(vertical = 30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f)
                .padding(end = 8.dp),
            text = "ID",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            color = Color.White
        )
        Text(
            modifier = Modifier.weight(2f),
            text = "Nombre",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            color = Color.White

        )


    }
    Divider(modifier = Modifier.padding(horizontal = 16.dp))
}

@Composable
private fun EntidadRow(
    it: SistemaEntity,
    goToSistema: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
                goToSistema(it.sistemaId!!)

            },
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = it.sistemaId.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            Text(
                modifier = Modifier.weight(2f),
                text = it.nombre,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )


        }
    }
}