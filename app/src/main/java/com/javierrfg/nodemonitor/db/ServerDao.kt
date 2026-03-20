package com.javierrfg.nodemonitor.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ServerDao {
    // Función para leer todos los servidores
    @Query("SELECT * FROM servers_table")
    fun getAllServers(): Flow<List<ServerEntity>>

    // Función para guardar una lista de servidores
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertServers(servers: List<ServerEntity>)
}