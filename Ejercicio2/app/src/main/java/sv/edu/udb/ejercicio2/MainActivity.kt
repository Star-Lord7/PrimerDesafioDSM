package sv.edu.udb.ejercicio2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la UI
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etSalarioBase = findViewById<EditText>(R.id.etSalarioBase)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val nombre = etNombre.text.toString()
            val salarioBase = etSalarioBase.text.toString().toDoubleOrNull()

            if (salarioBase != null) {
                // Lógica de Cálculo
                val afp = salarioBase * 0.0725
                val isss = salarioBase * 0.03
                val renta = calcularRenta(salarioBase)
                val salarioNeto = salarioBase - renta - afp - isss

                // Mostrar resultados
                val resultado = """
                    Empleado: $nombre
                    Salario Base: $${String.format("%.2f", salarioBase)}
                    Descuento Renta: $${String.format("%.2f", renta)}
                    Descuento AFP: $${String.format("%.2f", afp)}
                    Descuento ISSS: $${String.format("%.2f", isss)}
                    Salario Neto: $${String.format("%.2f", salarioNeto)}
                """.trimIndent()

                tvResultado.text = resultado
            } else {
                tvResultado.text = "Por favor ingrese un salario válido."
            }
        }
    }

    private fun calcularRenta(salarioBase: Double): Double {
        return when {
            salarioBase <= 472.00 -> 0.0
            salarioBase <= 895.24 -> (salarioBase - 472.00) * 0.10 + 17.67
            salarioBase <= 2038.10 -> (salarioBase - 895.24) * 0.20 + 60.00
            else -> (salarioBase - 2038.10) * 0.30 + 288.57
        }
    }
}
