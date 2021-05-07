package com.example.pm_lab2_calcu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder

class Calculadora : AppCompatActivity() {

    //Se crea la variable de cada componente
    //ya sea de tipo textview o button
    lateinit var txtResultado: TextView
    lateinit var txtOperacion: TextView

    lateinit var btnUno: Button
    lateinit var btnDos: Button
    lateinit var btnTres: Button
    lateinit var btnCuatro: Button
    lateinit var btnCinco: Button
    lateinit var btnSeis: Button
    lateinit var btnSiete: Button
    lateinit var btnOcho: Button
    lateinit var btnNueve: Button
    lateinit var btnCero: Button

    lateinit var btnMas: Button
    lateinit var btnMenos: Button
    lateinit var btnMulti: Button
    lateinit var btnDivi: Button
    lateinit var btnIgual: Button
    lateinit var btnCE: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        //Se asigna la dirección de cada variable de textView, textview solo muestra texto, no se puede interactuar con el
        //En este caso los dos textview son txtResultado, muestra el resultado de la operación
        //txtOperacion muestra el input de la operación solicitada
        txtResultado = findViewById(R.id.txtResultado)
        txtOperacion = findViewById(R.id.txtOperacion)

        //Se asigna la dirección de cada botón de los números en la calculadora
        btnUno = findViewById(R.id.btnUno)
        btnDos = findViewById(R.id.btnDos)
        btnTres = findViewById(R.id.btnTres)
        btnCuatro = findViewById(R.id.btnCuatro)
        btnCinco = findViewById(R.id.btnCinco)
        btnSeis = findViewById(R.id.btnSeis)
        btnSiete = findViewById(R.id.btnSiete)
        btnOcho = findViewById(R.id.btnOcho)
        btnNueve = findViewById(R.id.btnNueve)
        btnCero = findViewById(R.id.btnCero)

        //Se asigna la dirección de cada botón de los operadores en la calculadora
        btnMas = findViewById(R.id.btnMas)
        btnMenos = findViewById(R.id.btnMenos)
        btnMulti = findViewById(R.id.btnMulti)
        btnDivi = findViewById(R.id.btnDivi)
        btnIgual = findViewById(R.id.btnIgual)
        btnCE = findViewById(R.id.btnCE)


        //Función para hacer append de las operaciones
        fun append(clear: Boolean, string: String) {
            if (clear) {
                txtResultado.text = ""
                txtOperacion.append(string)
            } else {
                txtOperacion.append(txtResultado.text)
                txtOperacion.append(string)
                txtResultado.text = ""
            }
        }

        //Función que limpia o hace un clear de los textview
         fun CE() {
            txtOperacion.text = ""
            txtResultado.text = ""

        }

        //Función que calcula y realiza operaciones
         fun calcular() {

            try {
                //Implementé ExpressionBuilder en dependencies del gradle es de una libreria llamada exp4j evalua expresiones en este caso las operaciones básicas +,-,x,/
                val input = ExpressionBuilder(txtOperacion.text.toString()).build()
                val output = input.evaluate()
                txtResultado.text = output.toString()


            }catch (e:Exception){
                Toast.makeText(this@Calculadora,e.message,Toast.LENGTH_LONG).show()
            }
        }



        //OnClickListener está atento a cuando se apacha un botón
        btnCero.setOnClickListener { append(true, "0") }
        btnUno.setOnClickListener { append(true, "1") }
        btnDos.setOnClickListener { append(true, "2") }
        btnTres.setOnClickListener { append(true, "3") }
        btnCuatro.setOnClickListener { append(true, "4") }
        btnCinco.setOnClickListener { append(true, "5") }
        btnSeis.setOnClickListener { append(true, "6") }
        btnSiete.setOnClickListener { append(true, "7") }
        btnOcho.setOnClickListener { append(true, "8") }
        btnNueve.setOnClickListener { append(true, "9") }

        btnMas.setOnClickListener { append(false, "+") }
        btnMenos.setOnClickListener { append(false, "-") }
        btnMulti.setOnClickListener { append(false, "*") }
        btnDivi.setOnClickListener { append(false, "/") }

        btnCE.setOnClickListener {
            CE()
        }

        btnIgual.setOnClickListener {
            calcular()
        }


    }
}