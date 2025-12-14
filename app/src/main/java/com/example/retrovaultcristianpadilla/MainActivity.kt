package com.example.retrovaultcristianpadilla

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrovaultcristianpadilla.databinding.ActivityMainBinding
import com.example.retrovaultcristianpadilla.databinding.DialogJuegoBinding

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
            mostrarDialogo(null)
        }
    }

    private fun setupRecyclerView() {
        adapter = JuegoAdapter(
            onEdit = { juego ->
                mostrarDialogo(juego)
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

    private fun mostrarDialogo(juego: JuegoRetro?) {
        val dialogBinding = DialogJuegoBinding.inflate(layoutInflater)
        val isEditing = juego != null

        if (isEditing) {
            juego?.let {
                dialogBinding.editNombre.setText(it.nombre)
                dialogBinding.editPlataforma.setText(it.plataforma)
                dialogBinding.editGenero.setText(it.genero)
                dialogBinding.editAnio.setText(it.anio.toString())
                dialogBinding.editImagenUrl.setText(it.imagenUrl)
            }
        }

        val dialog = AlertDialog.Builder(this)
            .setTitle(if (isEditing) "Editar Juego" else "Nuevo Juego")
            .setView(dialogBinding.root)
            .setPositiveButton(if (isEditing) "Guardar" else "Crear") { _, _ ->
                val nombre = dialogBinding.editNombre.text.toString()
                val plataforma = dialogBinding.editPlataforma.text.toString()
                val genero = dialogBinding.editGenero.text.toString()
                val anio = dialogBinding.editAnio.text.toString().toIntOrNull() ?: 0
                val imagenUrl = dialogBinding.editImagenUrl.text.toString()

                if (nombre.isNotBlank() && plataforma.isNotBlank() && genero.isNotBlank() && imagenUrl.isNotBlank()) {
                    val nuevoJuego = JuegoRetro(nombre, plataforma, genero, anio, imagenUrl)
                    if (isEditing) {
                        juego?.let { juegoController.editarJuego(it, nuevoJuego) }
                    } else {
                        juegoController.agregarJuego(nuevoJuego)
                    }
                    updateJuegos()
                } else {
                    Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar", null)
            .create()

        dialog.show()
    }
}
