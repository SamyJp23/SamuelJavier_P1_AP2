package edu.ucne.samueljavier_p1_ap2.data.repository

import edu.ucne.samueljavier_p1_ap2.data.entity.SistemaEntity
import edu.ucne.samueljavier_p1_ap2.data.local.dao.SistemaDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SistemaRepository @Inject constructor(
    private val dao: SistemaDao
){
    suspend fun save(sistema: SistemaEntity) = dao.save(sistema)

    suspend fun find(id: Int) = dao.find(id)

    suspend fun delete(sistema: SistemaEntity) = dao.delete(sistema)

    fun getAll(): Flow<List<SistemaEntity>> = dao.getAll()

}


