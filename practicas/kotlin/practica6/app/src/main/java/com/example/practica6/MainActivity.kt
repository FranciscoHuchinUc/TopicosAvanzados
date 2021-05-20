package com.example.practica6

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.practica6.componentes.Game
import com.example.practica6.componentes.GameView
import com.example.practica6.interfaz.GameStateListener

class MainActivity : AppCompatActivity(), View.OnClickListener, GameStateListener {

    lateinit var ping: GameView
    lateinit var menuDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        crearDialog()

        var actionBar = supportActionBar
        actionBar?.hide()
    }

    private fun crearDialog(viewId: Int = R.layout.dialog_menu){
        menuDialog = AlertDialog.Builder(this).setView(viewId).setCancelable(false).create()
        menuDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        when (viewId){
            R.layout.dialog_pause -> {
            }
        }
    }

    override fun onResume() {
        super.onResume()
        menuDialog.show()
    }

    override fun onPause() {
        super.onPause()
        ping.stop()
    }

    override fun onClick(view: View?) {
        if (menuDialog.isShowing){
            menuDialog.dismiss()
        }

        when (view?.id){
            R.id.btnPlay -> {
                ping = GameView(this, view.id == R.id.btnPlay)
                setContentView(ping)
            }
            R.id.btnSalir -> this.finish()
            R.id.btnPause -> {
                ping.start()
            }
        }
    }

    override fun stateChanged(state: Game.STATE) {
        Log.d("Estado", "Cargando $state")
        when (state) {
            Game.STATE.END -> runOnUiThread({
                crearDialog(R.layout.dialog_menu)
                menuDialog.show()
            })
            Game.STATE.PAUSED -> runOnUiThread({
                crearDialog(R.layout.dialog_pause)
                menuDialog.show()
            })
        }
    }

}