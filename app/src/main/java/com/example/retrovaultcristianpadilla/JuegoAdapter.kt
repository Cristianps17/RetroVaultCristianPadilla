package com.example.retrovaultcristianpadilla

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrovaultcristianpadilla.databinding.ItemJuegoBinding

class JuegoAdapter(
    private val onEdit: (JuegoRetro) -> Unit,
    private val onDelete: (JuegoRetro) -> Unit
) : ListAdapter<JuegoRetro, JuegoAdapter.JuegoViewHolder>(JuegoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuegoViewHolder {
        val binding = ItemJuegoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JuegoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JuegoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class JuegoViewHolder(private val binding: ItemJuegoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(juego: JuegoRetro) {
            binding.nombreJuego.text = juego.nombre
            binding.plataformaJuego.text = juego.plataforma
            binding.generoJuego.text = juego.genero
            binding.anioJuego.text = juego.anio.toString()

            Glide.with(binding.imagenJuego.context)
                .load(juego.imagenUrl)
                .into(binding.imagenJuego)

            binding.botonEditar.setOnClickListener {
                onEdit(juego)
            }
            
            binding.botonBorrar.setOnClickListener {
                onDelete(juego)
            }
        }
    }
}

class JuegoDiffCallback : DiffUtil.ItemCallback<JuegoRetro>() {
    override fun areItemsTheSame(oldItem: JuegoRetro, newItem: JuegoRetro): Boolean {
        return oldItem.nombre == newItem.nombre // Assuming name is a unique identifier
    }

    override fun areContentsTheSame(oldItem: JuegoRetro, newItem: JuegoRetro): Boolean {
        return oldItem == newItem
    }
}
