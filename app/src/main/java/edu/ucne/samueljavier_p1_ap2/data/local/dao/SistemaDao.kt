package edu.ucne.samueljavier_p1_ap2.data.local.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import edu.ucne.samueljavier_p1_ap2.data.entity.SistemaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Upsert()
    suspend fun save(sistema: SistemaEntity)

    @Query(
        """
        SELECT * 
        FROM Sistemas 
        WHERE sistemaId=:id  
        LIMIT 1
        """
    )
    suspend fun find(id: Int): SistemaEntity?

    @Delete
    suspend fun delete(entidad: SistemaEntity)

    @Query("SELECT * FROM Sistemas")
    fun getAll(): Flow<List<SistemaEntity>>

}