package com.example.retrovaultcristianpadilla

class JuegoController {

    private val juegos = mutableListOf(
        JuegoRetro("Super Mario Bros.", "NES", "Plataformas", 1985, "https://upload.wikimedia.org/wikipedia/en/0/03/Super_Mario_Bros._box.png"),
        JuegoRetro("The Legend of Zelda", "NES", "Aventura", 1986, "https://upload.wikimedia.org/wikipedia/en/4/41/Legend_of_zelda_cover_%28with_cartridge%29_gold.png"),
        JuegoRetro("Sonic the Hedgehog", "Sega Genesis", "Plataformas", 1991, "https://upload.wikimedia.org/wikipedia/en/b/b4/Sonic_the_Hedgehog_1_Genesis_box_art.jpg"),
        JuegoRetro("Street Fighter II", "Arcade", "Lucha", 1991, "https://upload.wikimedia.org/wikipedia/en/1/1d/Street_Fighter_II_The_World_Warrior_flyer.png"),
        JuegoRetro("Chrono Trigger", "SNES", "RPG", 1995, "https://upload.wikimedia.org/wikipedia/en/a/a7/Chrono_Trigger_Box_Art.jpg")
    )

    fun getJuegos(): MutableList<JuegoRetro> {
        return juegos
    }

    fun borrarJuego(juego: JuegoRetro) {
        juegos.remove(juego)
    }
}
