package edu.ucne.samueljavier_p1_ap2.data.repository

import edu.ucne.samueljavier_p1_ap2.data.local.dao.Dao
import javax.inject.Inject

class EntidadRepository @Inject constructor(
    private val dao: Dao,
)


