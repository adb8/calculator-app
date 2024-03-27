package com.example.kotlin_calculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button1 = findViewById<MaterialButton>(R.id.button1)
        val button2 = findViewById<MaterialButton>(R.id.button2)
        val button3 = findViewById<MaterialButton>(R.id.button3)
        val button4 = findViewById<MaterialButton>(R.id.button4)
        val button5 = findViewById<MaterialButton>(R.id.button5)
        val button6 = findViewById<MaterialButton>(R.id.button6)
        val button7 = findViewById<MaterialButton>(R.id.button7)
        val button8 = findViewById<MaterialButton>(R.id.button8)
        val button9 = findViewById<MaterialButton>(R.id.button9)
        val button0 = findViewById<MaterialButton>(R.id.button0)
        val buttonadd = findViewById<MaterialButton>(R.id.buttonadd)
        val buttonsubtract = findViewById<MaterialButton>(R.id.buttonsubtract)
        val buttonmultiply = findViewById<MaterialButton>(R.id.buttonmultiply)
        val buttondivide = findViewById<MaterialButton>(R.id.buttondivide)
        val buttonclear = findViewById<MaterialButton>(R.id.buttonclear)
        val buttondot = findViewById<MaterialButton>(R.id.buttondot)
        val buttonequals = findViewById<MaterialButton>(R.id.buttonequals)
        val buttondelete = findViewById<MaterialButton>(R.id.buttondelete)
        val buttonrightp = findViewById<MaterialButton>(R.id.buttonrightp)
        val buttonleftp = findViewById<MaterialButton>(R.id.buttonleftp)
        val bottomText = findViewById<TextView>(R.id.bottomText)
        val topText = findViewById<TextView>(R.id.topText)

        var expression = ""
        var result = ""

        button1.setOnClickListener {
            expression += "1"
            topText.text = expression
        }
        button2.setOnClickListener {
            expression += "2"
            topText.text = expression
        }
        button3.setOnClickListener {
            expression += "3"
            topText.text = expression
        }
        button4.setOnClickListener {
            expression += "4"
            topText.text = expression
        }
        button5.setOnClickListener {
            expression += "5"
            topText.text = expression
        }
        button6.setOnClickListener {
            expression += "6"
            topText.text = expression
        }
        button7.setOnClickListener {
            expression += "7"
            topText.text = expression
        }
        button8.setOnClickListener {
            expression += "8"
            topText.text = expression
        }
        button9.setOnClickListener {
            expression += "9"
            topText.text = expression
        }
        button0.setOnClickListener {
            expression += "0"
            topText.text = expression
        }

        buttonadd.setOnClickListener {
            expression += "+"
            topText.text = expression
        }
        buttonsubtract.setOnClickListener {
            expression += "-"
            topText.text = expression
        }
        buttonmultiply.setOnClickListener {
            expression += "*"
            topText.text = expression
        }
        buttondivide.setOnClickListener {
            expression += "/"
            topText.text = expression
        }
        buttondot.setOnClickListener {
            expression += "."
            topText.text = expression
        }

        buttonrightp.setOnClickListener {
            expression += ")"
            topText.text = expression
        }
        buttonleftp.setOnClickListener {
            expression += "("
            topText.text = expression
        }

        buttonclear.setOnClickListener {
            expression = ""
            result = ""
            topText.text = expression
            bottomText.text = result
        }
        buttondelete.setOnClickListener {
            expression = expression.dropLast(1)
            topText.text = expression
        }

        fun evaluateExpression(expression: String): Double {
            val e = Expression(expression)
            return e.calculate()
        }

        buttonequals.setOnClickListener {
            try {
                result = evaluateExpression(expression).toString()
                if (result.substring(result.length - 2) == ".0") {
                    result = result.dropLast(2)
                }
                topText.text = result
                expression = result
                bottomText.text = result
            } catch (e: Exception) {
                bottomText.text = "Err"
            }
        }
    }
}