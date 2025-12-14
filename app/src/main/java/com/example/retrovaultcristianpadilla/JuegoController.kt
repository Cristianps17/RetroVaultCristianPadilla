package com.example.retrovaultcristianpadilla

class JuegoController {

    private val _juegos = mutableListOf(
        JuegoRetro("Super Mario Bros.", "NES", "Plataformas", 1985, "https://upload.wikimedia.org/wikipedia/en/0/03/Super_Mario_Bros._box.png"),
        JuegoRetro("The Legend of Zelda", "NES", "Aventura", 1986, "https://upload.wikimedia.org/wikipedia/en/4/41/Legend_of_zelda_cover_%28with_cartridge%29_gold.png"),
        JuegoRetro("Sonic the Hedgehog", "Sega Genesis", "Plataformas", 1991, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Sonic_The_Hedgehog.svg/500px-Sonic_The_Hedgehog.svg.png"),
        JuegoRetro("Street Fighter II", "Arcade", "Lucha", 1991, "https://static.wikia.nocookie.net/noob/images/e/e5/Street_Fighter_II_logotipo.png/revision/latest?cb=20160217005029&path-prefix=es"),
        JuegoRetro("Chrono Trigger", "SNES", "RPG", 1995, "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/613830/header.jpg?t=1719545360")
    )
    val juegos: List<JuegoRetro>
        get() = _juegos.toList()

    fun borrarJuego(juego: JuegoRetro) {
        _juegos.remove(juego)
    }

    fun agregarJuego(juego: JuegoRetro) {
        _juegos.add(juego)
    }

    fun editarJuego(juegoOriginal: JuegoRetro, juegoNuevo: JuegoRetro) {
        val index = _juegos.indexOf(juegoOriginal)
        if (index != -1) {
            _juegos[index] = juegoNuevo
        }
    }
}
