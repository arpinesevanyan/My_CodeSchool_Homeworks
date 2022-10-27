package com.example.mycodeschoolhomeworks.contract

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R

class LoginActivity : AppCompatActivity() {

    private lateinit var buttonLogin01: AppCompatButton
    private lateinit var backButtonData: AppCompatButton
    private lateinit var emailOrPhoneET: EditText
    private lateinit var passwordET: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin01 = findViewById(R.id.buttonLogin01)
        backButtonData = findViewById(R.id.backButtonData)
        emailOrPhoneET = findViewById(R.id.emailOrPhoneET)
        passwordET = findViewById(R.id.passwordET)

        backButtonData.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        buttonLogin01.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra(USER_NAME, emailOrPhoneET.text.toString())
            returnIntent.putExtra(PASSWORD, passwordET.text.toString())
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }

    companion object {
        const val USER_NAME = "user name"
        const val PASSWORD = "password"
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}



