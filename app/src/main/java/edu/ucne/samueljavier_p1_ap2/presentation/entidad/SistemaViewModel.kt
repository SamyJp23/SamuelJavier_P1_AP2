package edu.ucne.samueljavier_p1_ap2.presentation.entidad

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.samueljavier_p1_ap2.data.entity.SistemaEntity
import edu.ucne.samueljavier_p1_ap2.data.repository.SistemaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SistemaViewModel @Inject constructor(
    private val sistemaRepository: SistemaRepository) : ViewModel(){
    private val _uiState = MutableStateFlow(SistemaUiState())
    val uiState = _uiState.asStateFlow()

    init{
        getEntidades()
    }
    fun save(){
        viewModelScope.launch {
            if(isValid()){
                sistemaRepository.save(_uiState.value.toEntity())
            }
        }
    }
    fun onNombreChange(nombre: String){
        _uiState.update {
            it.copy(
                nombre = nombre,
                errorMessage = if(nombre.isBlank()) "Campo obligatorio"
                else null
            )
        }
    }


    fun new(){
        _uiState.value = SistemaUiState()
    }
    fun delete(){
        viewModelScope.launch {
            sistemaRepository.delete(_uiState.value.toEntity())
        }
    }
    private fun getEntidades(){
        viewModelScope.launch {
            sistemaRepository.getAll().collect{ sistemas ->
                _uiState.update {
                    it.copy(sistemas = sistemas)
                }
            }
        }
    }

    fun find(sistemaId: Int){
        viewModelScope.launch {
            if (sistemaId > 0) {
                val sistema = sistemaRepository.find(sistemaId)
                if (sistema != null) {
                    _uiState.update {
                        it.copy(
                            sistemaId = sistema.sistemaId,
                            nombre = sistema.nombre

                        )
                    }
                }
            }
        }
    }
    fun isValid(): Boolean {
        val nombreValid = _uiState.value.nombre.isNotBlank()


        _uiState.update {
            it.copy(
                errorMessage = when {
                    !nombreValid -> "Debes rellenar el campo nombre"
                    else -> null
                }
            )
        }

        return nombreValid
    }
}
fun SistemaUiState.toEntity() = SistemaEntity(
    sistemaId = this.sistemaId,
    nombre = this.nombre

)


