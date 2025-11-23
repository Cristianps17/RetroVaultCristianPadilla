package com.example.retrovaultcristianpadilla

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrovaultcristianpadilla.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: JuegoAdapter
    private val juegoController = JuegoController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        binding.fab.setOnClickListener {
            // Lógica para añadir un nuevo juego
        }
    }

    private fun setupRecyclerView() {
        adapter = JuegoAdapter(juegoController.getJuegos()) { juego ->
            juegoController.borrarJuego(juego)
            adapter.updateData(juegoController.getJuegos())
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
