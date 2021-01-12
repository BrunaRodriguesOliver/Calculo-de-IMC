package com.example.calculadoraimc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcula.setOnClickListener {
            val peso = txtPeso.text.toString()
            val altura = txtAltura.text.toString()
            if (peso.isEmpty()){
                mensagem.setText("Informe seu peso")
            } else if (altura.isEmpty()){
                mensagem.setText("Informe sua altura")
            } else {
                CalculoIMC()
            }
        }
        
        iconDelete.setOnTouchListener { v, event ->
            if(event.action == MotionEvent.ACTION_DOWN){
                txtPeso.setText("")
                txtAltura.setText("")
                mensagem.setText("")
            }
            false }

    }

    fun CalculoIMC(){
        btnCalcula.setOnClickListener{
            val peso = java.lang.Float.parseFloat(txtPeso.text.toString())
            val altura = java.lang.Float.parseFloat(txtAltura.text.toString())

            val imc = peso / (altura * altura)

            val resultado =when{
                imc <= 18.5 -> "Peso Baixo"
                imc <= 24.9 -> "Peso Normal"
                imc <= 29.9 -> "Sobrepeso"
                imc <= 34.9 -> "Obesidade (Grau I)"
                imc <= 39.9 -> "Obesidade (Grau II)"
                else -> "Obeidade Mórbida (Grau III)"
            }
            mensagem.text = "IMC" + " " + imc.toString() + "\n" + resultado
        }
    }
}