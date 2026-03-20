package com.javierrfg.nodemonitor.ui

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javierrfg.nodemonitor.databinding.ItemServerBinding
import com.javierrfg.nodemonitor.db.ServerEntity

class ServerAdapter(private val serverList: List<ServerEntity>) :
    RecyclerView.Adapter<ServerAdapter.ServerViewHolder>() {

    inner class ServerViewHolder(val binding: ItemServerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServerViewHolder {
        val binding = ItemServerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return serverList.size
    }

    override fun onBindViewHolder(holder: ServerViewHolder, position: Int) {
        val server = serverList[position]

        holder.binding.tvServerName.text = server.name
        holder.binding.tvDbType.text = server.dbType

        if (server.currentStatus == "Online") {
            holder.binding.ivStatusDot.setColorFilter(Color.parseColor("#4CAF50"))
        } else {
            holder.binding.ivStatusDot.setColorFilter(Color.parseColor("#F44336"))
        }

        // Le decimos a toda la fila que escuche cuando el usuario haga clic
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context

            // Creamos un Intent para viajar a la pantalla de detalle
            val intent = Intent(context, ServerDetailActivity::class.java).apply {
                // Empaquetamos los datos del servidor para que viajen a la otra pantalla
                putExtra("EXTRA_NAME", server.name)
                putExtra("EXTRA_STATUS", server.currentStatus)
                putExtra("EXTRA_CPU", server.cpuUsage)
                putExtra("EXTRA_CONN", server.connections)
                putExtra("EXTRA_TYPE", server.dbType)
            }
            context.startActivity(intent)
        }
    }
}