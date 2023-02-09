package com.ucne.proj_1erparcial_ap2.data.local.dao

import androidx.room.*
import com.ucne.proj_1erparcial_ap2.data.local.entity.PrestamoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(prestamoEntity: PrestamoEntity)

    suspend fun delete(prestamoEntity: PrestamoEntity)

    @Query(
        """
         SELECT *
         FROM Prestamos
         WHERE DeudorId =: deudorId
         LIMIT 1
        """
    )
    suspend fun find(deudorId: Int): PrestamoDao?

    @Query(
        """SELECT *
 FROM Prestamos
 ORDER BY deudorId desc
 """
    )
    fun getList(): Flow<List<PrestamoEntity>>
}

class dao {
    fun save(): Boolean {
        return true
    }
}



