package com.javierrfg.nodemonitor.data

// Modelo para recibir los datos del servidor externo
data class ServerNetworkResponse(
    val serverId: Int,
    val serverName: String,
    val databaseType: String,
    val status: String,
    val cpuUsagePercentage: Double,
    val activeConnections: Int
)