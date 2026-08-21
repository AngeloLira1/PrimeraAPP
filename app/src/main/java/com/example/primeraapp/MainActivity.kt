package com.example.primeraapp

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity(){

    //Vinculamos el ViewModel a esta Activity

    private val miViewModel: ContadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvContador: TextView = findViewById(R.id.tvContador)
        val btnSumar: Button= findViewById(R.id.btnSumar)
        val btnRestar: Button= findViewById(R.id.btnRestar)

        //OBSERVADOR: Cada vez que el numero cambie el ViewModel
        //este bloque de código se ejecutará automáticamente.
        miViewModel.numero.observe(this){ valorActualizado ->
            tvContador.text= valorActualizado.toString()
        }

        //EVENTOS: Solo mandamos la orden al ViewModel

        btnSumar.setOnClickListener { miViewModel.incrementar() }
        btnRestar.setOnClickListener { miViewModel.decrementar() }
    }

}


