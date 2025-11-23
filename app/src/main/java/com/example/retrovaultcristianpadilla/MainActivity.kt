package com.example.retrovaultcristianpadilla

import android.os.Bundle
import android.widget.Toast
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
        updateJuegos()

        binding.fab.setOnClickListener {
            Toast.makeText(this, "Añadir nuevo juego", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView() {
        adapter = JuegoAdapter(
            onEdit = { juego ->
                Toast.makeText(this, "Editando: ${juego.nombre}", Toast.LENGTH_SHORT).show()
            },
            onDelete = { juego ->
                juegoController.borrarJuego(juego)
                updateJuegos()
                Toast.makeText(this, "Juego borrado: ${juego.nombre}", Toast.LENGTH_SHORT).show()
            }
        )
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun updateJuegos() {
        adapter.submitList(juegoController.juegos)
    }
}
