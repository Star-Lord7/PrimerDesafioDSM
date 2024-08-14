package com.example.ejercicio3desafio1
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etOperando1 = findViewById<EditText>(R.id.etOperando1)
        val etOperando2 = findViewById<EditText>(R.id.etOperando2)
        val spinnerOperacion = findViewById<Spinner>(R.id.spinnerOperacion)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Configurar el Spinner con las operaciones básicas
        val operaciones = arrayOf("Suma", "Resta", "Multiplicación", "División")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operaciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOperacion.adapter = adapter

        btnCalcular.setOnClickListener {
            val operando1 = etOperando1.text.toString().toDoubleOrNull()
            val operando2 = etOperando2.text.toString().toDoubleOrNull()
            val operacion = spinnerOperacion.selectedItem.toString()

            if (operando1 == null || operando2 == null) {
                Toast.makeText(this, "Por favor ingresa números válidos.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val resultado = when (operacion) {
                "Suma" -> operando1 + operando2
                "Resta" -> operando1 - operando2
                "Multiplicación" -> operando1 * operando2
                "División" -> {
                    if (operando2 != 0.0) {
                        operando1 / operando2
                    } else {
                        Toast.makeText(this, "No se puede dividir por cero.", Toast.LENGTH_LONG).show()
                        return@setOnClickListener
                    }
                }
                else -> 0.0
            }
            tvResultado.text = "Resultado: $resultado"
        }
    }
}
