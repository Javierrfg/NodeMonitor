package com.javierrfg.nodemonitor.db

import androidx.room.Entity
import androidx.room.PrimaryKey

// Tabla local para guardar el estado de los servidores y usarlos sin internet
@Entity(tableName = "servers_table")
data class ServerEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val dbType: String,
    val currentStatus: String,
    val cpuUsage: Double,
    val connections: Int
)
