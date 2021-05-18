package com.example.practica5

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Declaracion de Variables
    lateinit var usuario: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    //
    fun formLoginOk() {
//        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
//        builder.setTitle(" ")
//        builder.setMessage("Inicio de Sesion Correcto")
//        builder.setIcon(R.drawable.correct)
//
//        builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, which ->
//            dialog.dismiss()
//            mostrarPantalla()
//        })
//        builder.show()
        Toast.makeText(applicationContext, "Inicio de Sesion Correcto", Toast.LENGTH_SHORT).show()
        mostrarPantalla()
    }

    fun formLoginError() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(" ")
        builder.setMessage("Error de Usuario y/o Contraseña")
        builder.setIcon(R.drawable.icon_error)

        builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        builder.show()
    }

    fun validarUsuario(view: View) {
        init()
        if(usuario.length() == 0 || password.length() == 0){
            Toast.makeText(applicationContext, "No puede dejar ningun campo Vacio", Toast.LENGTH_SHORT).show()
        } else {
            if (usuario.text.toString().equals("francisco_huchin") && password.text.toString().equals("0858")) {
                formLoginOk()
            } else {
                formLoginError()
            }
        }
    }

    fun mostrarPantalla(){
        val loggHome = Intent(this, homeLogin:: class.java)
        startActivity(loggHome)
    }

    fun init(){
        usuario = findViewById(R.id.txtUser)
        password = findViewById(R.id.txtPassword)
    }


}