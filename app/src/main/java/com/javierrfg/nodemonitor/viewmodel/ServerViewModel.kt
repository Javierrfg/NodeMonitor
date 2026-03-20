package com.javierrfg.nodemonitor.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.javierrfg.nodemonitor.db.AppDatabase
import com.javierrfg.nodemonitor.network.RetrofitClient
import com.javierrfg.nodemonitor.repository.ServerRepository
import kotlinx.coroutines.launch

class ServerViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ServerRepository
    val allServers: kotlinx.coroutines.flow.Flow<List<com.javierrfg.nodemonitor.db.ServerEntity>>

    init {
        // Inicializamos la base de datos, la API y el repositorio
        val serverDao = AppDatabase.getDatabase(application).serverDao()
        val apiService = RetrofitClient.apiService
        repository = ServerRepository(apiService, serverDao)

        allServers = repository.allServers
    }

    // Usamos Coroutines para no congelar la pantalla mientras descarga
    fun fetchServersFromApi() {
        viewModelScope.launch {
            repository.refreshServers()
        }
    }
}