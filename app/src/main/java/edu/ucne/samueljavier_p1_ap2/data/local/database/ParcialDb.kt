package edu.ucne.samueljavier_p1_ap2.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.samueljavier_p1_ap2.data.entity.SistemaEntity
import edu.ucne.samueljavier_p1_ap2.data.local.dao.SistemaDao

@Database(
    entities = [
        SistemaEntity::class,
    ],
    version =  1,
    exportSchema = false
)
abstract class ParcialDb : RoomDatabase(){
    abstract fun Dao(): SistemaDao
}