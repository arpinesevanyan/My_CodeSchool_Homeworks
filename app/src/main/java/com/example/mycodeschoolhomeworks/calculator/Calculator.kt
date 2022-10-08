package com.example.mycodeschoolhomeworks.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R
import net.objecthunter.exp4j.ExpressionBuilder

class Calculator : AppCompatActivity(), View.OnClickListener {

    private lateinit var math_operation: TextView
    private lateinit var result_text: TextView
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
            math_operation.text = ""
            result_text.text = ""
        }

        backButton.setOnClickListener {
            val str = math_operation.text.toString()
            if (str.isNotEmpty())
                math_operation.text = str.substring(0, str.length - 1)
            result_text.text = ""
        }

        equalButton.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
            } catch (e: Exception) {
                Log.d("error", "message: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String) {
        math_operation.append(str)
    }

    override fun onClick(view: View?) {

    }
}
