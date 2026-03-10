package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var oper: Int=0
    var numero1: Double = 0.0
    lateinit var tv_num: TextView
    lateinit var tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tv_num = findViewById(R.id.tv_num)
        tv_num2 = findViewById(R.id.tv_num2)
        val buttonC: Button= findViewById(R.id.buttonC)
        val igual: Button = findViewById(R.id.igual)

        igual.setOnClickListener{
            var  numero2: Double = tv_num2.text.toString().toDouble()
            var resp: Double = 0.0

            when(oper){
                1-> resp = numero1 + numero2
                2-> resp = numero1 - numero2
                3-> resp = numero1 * numero2
                4-> resp = numero1 / numero2
            }
            tv_num2.setText(resp.toString())
            tv_num.setText("")
        }
        buttonC.setOnClickListener{
            tv_num.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            oper = 0
        }
    }

    fun presionarDigito(view: View) {
        //val tv_num2: TextView = findViewById(R.id.tv_num2)
        var num2: String = tv_num2.text.toString()

        when (view.id) {
            R.id.boton0 -> tv_num2.setText(num2 + "0")
            R.id.boton1 -> tv_num2.setText(num2 + "1")
            R.id.boton2 -> tv_num2.setText(num2 + "2")
            R.id.boton3 -> tv_num2.setText(num2 + "3")
            R.id.boton4 -> tv_num2.setText(num2 + "4")
            R.id.boton5 -> tv_num2.setText(num2 + "5")
            R.id.boton6 -> tv_num2.setText(num2 + "6")
            R.id.boton7 -> tv_num2.setText(num2 + "7")
            R.id.boton8 -> tv_num2.setText(num2 + "8")
            R.id.boton9 -> tv_num2.setText(num2 + "9")

        }
    }

    fun clicOperacion(view: View) {
        numero1 = tv_num2.text.toString().toDouble()
    var num2_text: String = tv_num2.text.toString()
        tv_num2.setText("")
        when(view.id){
            R.id.sumar ->{
                tv_num.setText(num2_text + "+")
                oper = 1
            }
            R.id.restar ->{
                tv_num.setText(num2_text + "-")
                oper = 2
            }
            R.id.multiplicar ->{
                tv_num.setText(num2_text + "*")
                oper = 3
            }
            R.id.dividir ->{
                tv_num.setText(num2_text + "/")
                oper = 4

            }
        }
    }
}