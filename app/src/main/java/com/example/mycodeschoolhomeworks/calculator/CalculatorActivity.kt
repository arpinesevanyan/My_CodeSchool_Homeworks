package com.example.mycodeschoolhomeworks.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mathOperation: TextView
    private lateinit var resultText: TextView
    private lateinit var number1Button: AppCompatButton
    private lateinit var number2Button: AppCompatButton
    private lateinit var number3Button: AppCompatButton
    private lateinit var number4Button: AppCompatButton
    private lateinit var number5Button: AppCompatButton
    private lateinit var number6Button: AppCompatButton
    private lateinit var number7Button: AppCompatButton
    private lateinit var number8Button: AppCompatButton
    private lateinit var number9Button: AppCompatButton
    private lateinit var number0Button: AppCompatButton
    private lateinit var dotButton: AppCompatButton
    private lateinit var minusButton: AppCompatButton
    private lateinit var plusButton: AppCompatButton
    private lateinit var multiplyButton: AppCompatButton
    private lateinit var divisionButton: AppCompatButton
    private lateinit var percentButton: AppCompatButton
    private lateinit var clearButton: AppCompatButton
    private lateinit var backButton: AppCompatButton
    private lateinit var equalButton: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        number1Button = findViewById(R.id.number1Button)
        number2Button = findViewById(R.id.number2Button)
        number3Button = findViewById(R.id.number3Button)
        number4Button = findViewById(R.id.number4Button)
        number5Button = findViewById(R.id.number5Button)
        number6Button = findViewById(R.id.number6Button)
        number7Button = findViewById(R.id.number7Button)
        number8Button = findViewById(R.id.number8Button)
        number9Button = findViewById(R.id.number9Button)
        number0Button = findViewById(R.id.number0Button)

        dotButton = findViewById(R.id.dotButton)
        minusButton = findViewById(R.id.minusButton)
        plusButton = findViewById(R.id.plusButton)
        multiplyButton = findViewById(R.id.multiplyButton)
        divisionButton = findViewById(R.id.divisionButton)
        percentButton = findViewById(R.id.percentButton)
        clearButton = findViewById(R.id.clearButton)
        equalButton = findViewById(R.id.equalButton)
        backButton = findViewById(R.id.backButton)

    }

    fun setTextFields(str: String) {
        mathOperation.append(str)
    }

    override fun onClick(view: View?) {
        number1Button.setOnClickListener { setTextFields("1") }
        number2Button.setOnClickListener { setTextFields("2") }
        number3Button.setOnClickListener { setTextFields("3") }
        number4Button.setOnClickListener { setTextFields("4") }
        number5Button.setOnClickListener { setTextFields("5") }
        number6Button.setOnClickListener { setTextFields("6") }
        number7Button.setOnClickListener { setTextFields("7") }
        number8Button.setOnClickListener { setTextFields("8") }
        number9Button.setOnClickListener { setTextFields("9") }
        number0Button.setOnClickListener { setTextFields("0") }
        dotButton.setOnClickListener { setTextFields(".") }
        minusButton.setOnClickListener { setTextFields("-") }
        plusButton.setOnClickListener { setTextFields("+") }
        multiplyButton.setOnClickListener { setTextFields("*") }
        divisionButton.setOnClickListener { setTextFields("/") }
        percentButton.setOnClickListener { setTextFields("%") }
        clearButton.setOnClickListener {
            mathOperation.text = ""
            resultText.text = ""
        }

        backButton.setOnClickListener {
            val str = mathOperation.text.toString()
            if (str.isNotEmpty())
                mathOperation.text = str.substring(0, str.length - 1)
            resultText.text = ""
        }

        equalButton.setOnClickListener {
            try {
                val ex = ExpressionBuilder(mathOperation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    resultText.text = longRes.toString()
                else
                    resultText.text = result.toString()
            } catch (e: Exception) {
                Log.d("error", "message: ${e.message}")
            }
        }
    }
}
