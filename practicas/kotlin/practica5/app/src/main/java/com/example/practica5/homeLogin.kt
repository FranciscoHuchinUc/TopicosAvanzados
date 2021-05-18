package com.example.practica5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class homeLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_login)
    }

    fun RetunActivity(view: View){
        finish()
    }
}