package com.example.ejercicio1desafio1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NombreEstudiante = findViewById<EditText>(R.id.NombreEstudiante)
        val Nota1 = findViewById<EditText>(R.id.Nota1)
        val Nota2 = findViewById<EditText>(R.id.Nota2)
        val Nota3 = findViewById<EditText>(R.id.Nota3)
        val Nota4 = findViewById<EditText>(R.id.Nota4)
        val Nota5 = findViewById<EditText>(R.id.Nota5)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val Resultado = findViewById<TextView>(R.id.Resultado)

        btnCalcular.setOnClickListener {
            val studentName = NombreEstudiante.text.toString()

            val note1 = Nota1.text.toString().toDoubleOrNull()
            val note2 = Nota2.text.toString().toDoubleOrNull()
            val note3 = Nota3.text.toString().toDoubleOrNull()
            val note4 = Nota4.text.toString().toDoubleOrNull()
            val note5 = Nota5.text.toString().toDoubleOrNull()

            if (studentName.isEmpty() || note1 == null || note2 == null || note3 == null || note4 == null || note5 == null) {
                Toast.makeText(this, "Por favor, rellene todos los campos correctamente.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (note1 !in 0.0..10.0 || note2 !in 0.0..10.0 || note3 !in 0.0..10.0 || note4 !in 0.0..10.0 || note5 !in 0.0..10.0) {
                Toast.makeText(this, "Las notas deben estar entre 0 y 10.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val promedio = (note1 * 0.15) + (note2 * 0.15) + (note3 * 0.20) + (note4 * 0.25) + (note5 * 0.25)
            val promedioRedondeado = String.format("%.2f", promedio).toDouble()
            val estado = if (promedio >= 6) "aprobado" else "reprobado"

            Resultado.text = "$studentName, su nota final es de $promedioRedondeado, y haz sido $estado."
        }
    }
}
