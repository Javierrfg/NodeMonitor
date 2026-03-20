package com.javierrfg.nodemonitor.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.javierrfg.nodemonitor.databinding.ActivityServerDetailBinding

class ServerDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServerDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityServerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recibimos los datos que vienen desde la lista a través del Intent
        val serverName = intent.getStringExtra("EXTRA_NAME") ?: "Servidor Desconocido"
        val serverStatus = intent.getStringExtra("EXTRA_STATUS") ?: "Desconocido"
        val serverCpu = intent.getDoubleExtra("EXTRA_CPU", 0.0)
        val serverConnections = intent.getIntExtra("EXTRA_CONN", 0)
        val serverType = intent.getStringExtra("EXTRA_TYPE") ?: "N/A"

        // Colocamos los datos en la pantalla
        binding.tvDetailName.text = serverName
        binding.tvDetailStatus.text = "Estado: $serverStatus"
        binding.tvDetailCpu.text = "Uso de CPU: $serverCpu%"
        binding.tvDetailConnections.text = "Conexiones Activas: $serverConnections"
        binding.tvDetailType.text = "Motor: $serverType"

        // Cambiamos el color del estado a rojo si está Offline
        if (serverStatus == "Offline") {
            binding.tvDetailStatus.setTextColor(android.graphics.Color.parseColor("#F44336"))
        }

        // Preparando el botón para el formulario de la pantalla 4
        binding.btnReportIssue.setOnClickListener {
            val intentToReport = android.content.Intent(this, ReportIssueActivity::class.java)
            // Le pasamos el nombre del servidor a la siguiente pantalla
            intentToReport.putExtra("EXTRA_SERVER_NAME", serverName)
            startActivity(intentToReport)
        }
    }
}