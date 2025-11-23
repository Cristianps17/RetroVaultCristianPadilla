package com.example.retrovaultcristianpadilla

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrovaultcristianpadilla.databinding.ItemJuegoBinding

class JuegoAdapter(
    private var juegos: MutableList<JuegoRetro>,
    private val onDelete: (JuegoRetro) -> Unit
) : RecyclerView.Adapter<JuegoAdapter.JuegoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuegoViewHolder {
        val binding = ItemJuegoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JuegoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JuegoViewHolder, position: Int) {
        holder.bind(juegos[position])
    }

    override fun getItemCount(): Int = juegos.size

    fun updateData(newJuegos: List<JuegoRetro>) {
        juegos.clear()
        juegos.addAll(newJuegos)
        notifyDataSetChanged()
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

            binding.botonBorrar.setOnClickListener {
                onDelete(juego)
            }
        }
    }
}
