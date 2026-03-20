package com.javierrfg.nodemonitor.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.javierrfg.nodemonitor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declaramos la variable para el ViewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cargamos el diseño XML
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnter.setOnClickListener {
            // Navegamos de MainActivity a ServerListActivity
            val intent = android.content.Intent(this, ServerListActivity::class.java)
            startActivity(intent)
        }

        }
    }