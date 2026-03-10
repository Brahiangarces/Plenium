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

    // 0 = nada, 1 = suma, 2 = resta, 3 = multiplicacion, 4 = division
    var oper: Int = 0
    var numero1: Double = 0.0

    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)

        val btBorrar: Button = findViewById(R.id.btnc)
        val btnIgual: Button = findViewById(R.id.btnequals)

        btnIgual.setOnClickListener {
            val numero2: Double = tv_num2.text.toString().toDoubleOrNull() ?: 0.0
            var resp: Double = 0.0

            when (oper) {
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> {
                    if (numero2 != 0.0) {
                        resp = numero1 / numero2
                    } else {
                        tv_num2.text = "Error"
                        tv_num1.text = ""
                        oper = 0
                        numero1 = 0.0
                        return@setOnClickListener
                    }
                }
            }

            tv_num2.text = resp.toString()
            tv_num1.text = ""
            oper = 0
            numero1 = 0.0
        }

        btBorrar.setOnClickListener {
            tv_num1.text = ""
            tv_num2.text = ""
            numero1 = 0.0
            oper = 0
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun presionarDigito(view: View) {
        val num2 = tv_num2.text.toString()

        when (view.id) {
            R.id.btn0 -> tv_num2.text = num2 + "0"
            R.id.btn1 -> tv_num2.text = num2 + "1"
            R.id.btn2 -> tv_num2.text = num2 + "2"
            R.id.btn3 -> tv_num2.text = num2 + "3"
            R.id.btn4 -> tv_num2.text = num2 + "4"
            R.id.btn5 -> tv_num2.text = num2 + "5"
            R.id.btn6 -> tv_num2.text = num2 + "6"
            R.id.btn7 -> tv_num2.text = num2 + "7"
            R.id.btn8 -> tv_num2.text = num2 + "8"
            R.id.btn9 -> tv_num2.text = num2 + "9"
            R.id.btnpoint -> tv_num2.text = num2 + "."
        }
    }

    fun clickOperacion(view: View) {
        numero1 = tv_num2.text.toString().toDoubleOrNull() ?: 0.0
        val num2: String = tv_num2.text.toString()

        when (view.id) {
            R.id.btnplus -> {
                tv_num1.text = num2 + "+"
                oper = 1
            }

            R.id.btnless -> {
                tv_num1.text = num2 + "-"
                oper = 2
            }

            R.id.btnmultipli -> {
                tv_num1.text = num2 + "*"
                oper = 3
            }

            R.id.btndivision -> {
                tv_num1.text = num2 + "/"
                oper = 4
            }
        }

        tv_num2.text = ""
    }
}