package com.example.primeraapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // 1. Declaramos el ViewModel UNA sola vez
    private val miViewModel: ContadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. Referenciamos las vistas del XML
        val tvContador: TextView = findViewById(R.id.tvContador)
        val btnSumar: Button = findViewById(R.id.btnSumar)
        val btnRestar: Button = findViewById(R.id.btnRestar)
        val btnReset: Button = findViewById(R.id.btnReset)

        // 3. OBSERVADOR: Escucha cambios y actualiza texto y color
        miViewModel.numero.observe(this) { cantidad ->
            tvContador.text = cantidad.toString()

            if (cantidad == 10) {
                tvContador.setTextColor(Color.RED)
            } else {
                tvContador.setTextColor(Color.BLACK)
            }
        }

        // 4. EVENTOS: Asignación de clics a los botones
        btnSumar.setOnClickListener {
            miViewModel.incrementar()
        }

        btnRestar.setOnClickListener {
            miViewModel.decrementar()
        }

        btnReset.setOnClickListener {
            miViewModel.reset()
        }


    }
}


