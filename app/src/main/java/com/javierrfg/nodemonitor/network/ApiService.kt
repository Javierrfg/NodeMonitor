package com.javierrfg.nodemonitor.network

import com.javierrfg.nodemonitor.data.ServerNetworkResponse
import retrofit2.http.GET

interface ApiService {
    // Simularemos un endpoint llamado /servers
    @GET("servers")
    suspend fun getServers(): List<ServerNetworkResponse>
}