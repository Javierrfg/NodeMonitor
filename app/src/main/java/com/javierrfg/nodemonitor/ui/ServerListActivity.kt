package com.javierrfg.nodemonitor.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.javierrfg.nodemonitor.databinding.ActivityServerListBinding
import com.javierrfg.nodemonitor.db.ServerEntity

class ServerListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServerListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configuramos el ViewBinding para esta pantalla
        binding = ActivityServerListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Creamos unos datos de prueba
        val servidoresDePrueba = listOf(
            ServerEntity(1, "Producción Ventas", "Oracle", "Online", 45.5, 120),
            ServerEntity(2, "Backup Recursos Humanos", "PostgreSQL", "Online", 20.1, 15),
            ServerEntity(3, "Servidor de Pruebas (QA)", "MySQL", "Offline", 0.0, 0),
            ServerEntity(4, "Almacenamiento Cloud", "MongoDB", "Online", 78.9, 340)
        )

        // 2. Le decimos al RecyclerView cómo ordenarse
        binding.recyclerViewServers.layoutManager = LinearLayoutManager(this)

        // 3. Conectamos los datos de prueba con nuestro Adapter
        val adapter = ServerAdapter(servidoresDePrueba)
        binding.recyclerViewServers.adapter = adapter
    }
}