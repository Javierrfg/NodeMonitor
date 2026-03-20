package com.javierrfg.nodemonitor.repository

import com.javierrfg.nodemonitor.db.ServerDao
import com.javierrfg.nodemonitor.db.ServerEntity
import com.javierrfg.nodemonitor.network.ApiService
import kotlinx.coroutines.flow.Flow

class ServerRepository(private val apiService: ApiService, private val serverDao: ServerDao) {

    // Obtiene los servidores guardados localmente en el teléfono
    val allServers: Flow<List<ServerEntity>> = serverDao.getAllServers()

    // Coroutines para descargar de internet y guardar en el teléfono
    suspend fun refreshServers() {
        try {
            val networkServers = apiService.getServers()

            // Convertimos los datos de internet al formato de nuestra base de datos local
            val serverEntities = networkServers.map {
                ServerEntity(
                    id = it.serverId,
                    name = it.serverName,
                    dbType = it.databaseType,
                    currentStatus = it.status,
                    cpuUsage = it.cpuUsagePercentage,
                    connections = it.activeConnections
                )
            }
            // Guardamos todo en Room
            serverDao.insertServers(serverEntities)
        } catch (e: Exception) {
            // Aquí la app entraría si no hay internet. Como usamos Room,
            // no se cae, simplemente muestra los últimos datos guardados.
        }
    }
}