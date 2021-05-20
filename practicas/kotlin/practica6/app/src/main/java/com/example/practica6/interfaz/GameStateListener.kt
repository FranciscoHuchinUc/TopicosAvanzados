package com.example.practica6.interfaz

import com.example.practica6.componentes.Game

interface GameStateListener {
    fun stateChanged(state: Game.STATE)
}