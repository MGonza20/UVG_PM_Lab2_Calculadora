package com.example.pm_lab2_calcu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder

class Calculadora : AppCompatActivity() {


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
    lateinit var btnBorrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        //Botones de números


        txtResultado = findViewById(R.id.txtResultado)
        txtOperacion = findViewById(R.id.txtOperacion)


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

        btnMas = findViewById(R.id.btnMas)
        btnMenos = findViewById(R.id.btnMenos)
        btnMulti = findViewById(R.id.btnMulti)
        btnDivi = findViewById(R.id.btnDivi)
        btnIgual = findViewById(R.id.btnIgual)
        btnCE = findViewById(R.id.btnCE)
        btnBorrar = findViewById(R.id.btnBorrar)


        fun appendOnClick(clear: Boolean, string: String) {

            if (clear) {
                txtResultado.text = ""
                txtOperacion.append(string)
            } else {
                txtOperacion.append(txtResultado.text)
                txtOperacion.append(string)
                txtResultado.text = ""
            }
        }

         fun clear() {
            txtOperacion.text = ""
            txtResultado.text = ""

        }

         fun calculate() {

            try {

                val input = ExpressionBuilder(txtOperacion.text.toString()).build()
                val output = input.evaluate()
                val longOutput = output.toLong()
                if (output == longOutput.toDouble()){
                    txtResultado.text = longOutput.toString()
                }else{
                    txtResultado.text = output.toString()
                }

            }catch (e:Exception){
                Toast.makeText(this@Calculadora,e.message,Toast.LENGTH_LONG).show()
            }
        }



        btnCero.setOnClickListener { appendOnClick(true, "0") }
        btnUno.setOnClickListener { appendOnClick(true, "1") }
        btnDos.setOnClickListener { appendOnClick(true, "2") }
        btnTres.setOnClickListener { appendOnClick(true, "3") }
        btnCuatro.setOnClickListener { appendOnClick(true, "4") }
        btnCinco.setOnClickListener { appendOnClick(true, "5") }
        btnSeis.setOnClickListener { appendOnClick(true, "6") }
        btnSiete.setOnClickListener { appendOnClick(true, "7") }
        btnOcho.setOnClickListener { appendOnClick(true, "8") }
        btnNueve.setOnClickListener { appendOnClick(true, "9") }

        btnMas.setOnClickListener { appendOnClick(false, "+") }
        btnMenos.setOnClickListener { appendOnClick(false, "-") }
        btnMulti.setOnClickListener { appendOnClick(false, "*") }
        btnDivi.setOnClickListener { appendOnClick(false, "/") }

        btnCE.setOnClickListener {
            clear()
        }

        btnIgual.setOnClickListener {
            calculate()
        }


/*
        btnUno.setOnClickListener{
            Toast.makeText(this, "Uno", Toast.LENGTH_SHORT).show()
        }
        txtResultado.text = "Salut Mondee"
 */

    }
}