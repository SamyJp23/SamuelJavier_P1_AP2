package edu.ucne.samueljavier_p1_ap2.presentation.entidad

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.samueljavier_p1_ap2.data.local.dao.SistemaDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
@HiltViewModel
class EntidadViewModel @Inject constructor(
    private val dao: SistemaDao) : ViewModel(){
    private val _uiState = MutableStateFlow(SistemaUiState())
    val uiState = _uiState.asStateFlow()
}
fun SistemaUiState
{

}