package com.javierrfg.nodemonitor.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.javierrfg.nodemonitor.databinding.ActivityReportIssueBinding

class ReportIssueActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReportIssueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportIssueBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Recibimos el nombre del servidor desde la pantalla de detalle
        val serverName = intent.getStringExtra("EXTRA_SERVER_NAME") ?: "Servidor Desconocido"

        // Lo ponemos en la caja de texto para que el usuario no tenga que escribirlo
        binding.etServerName.setText(serverName)

        // 2. Configuramos el botón para abrir WhatsApp
        binding.btnSendWhatsApp.setOnClickListener {
            val title = binding.etIssueTitle.text.toString()
            val description = binding.etIssueDescription.text.toString()

            // Validamos que el usuario haya escrito algo
            if (title.isNotEmpty() && description.isNotEmpty()) {

                // Armamos el mensaje final con formato
                val message = "🚨 *Alerta Crítica: $serverName* 🚨\n\n*Asunto:* $title\n*Detalle:* $description"

                // Creamos el Intent implícito hacia WhatsApp
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://api.whatsapp.com/send?text=${Uri.encode(message)}")

                try {
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(this, "No se pudo abrir WhatsApp. Verifica si está instalado.", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}