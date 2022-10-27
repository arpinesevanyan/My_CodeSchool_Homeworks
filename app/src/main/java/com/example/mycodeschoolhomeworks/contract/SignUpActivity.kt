package com.example.mycodeschoolhomeworks.contract

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.contract.LoginActivity.Companion.PASSWORD
import com.example.mycodeschoolhomeworks.contract.LoginActivity.Companion.USER_NAME

class SignUpActivity : AppCompatActivity() {
    private lateinit var buttonSignUp: AppCompatButton
    private lateinit var backButtonSignUp: AppCompatButton
    private lateinit var emailOrPhoneETSignUp: EditText
    private lateinit var passwordETSignUp: EditText
    private lateinit var confirmPasswordETSignUp: EditText
    private lateinit var nameETSignUp: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sighn_up)

        buttonSignUp = findViewById(R.id.buttonSignUp)
        backButtonSignUp = findViewById(R.id.backButtonSignUp)
        emailOrPhoneETSignUp = findViewById(R.id.emailOrPhoneETSignUp)
        passwordETSignUp = findViewById(R.id.passwordETSignUp)
        confirmPasswordETSignUp = findViewById(R.id.confirmPasswordETSignUp)
        nameETSignUp = findViewById(R.id.nameETSignUp)

        backButtonSignUp.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        buttonSignUp.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra(USER_NAME, emailOrPhoneETSignUp.text.toString())
            returnIntent.putExtra(PASSWORD, passwordETSignUp.text.toString())
            returnIntent.putExtra(NAME_OR_PSEUDO, nameETSignUp.text.toString())
            returnIntent.putExtra(CONFIRM_PASSWORD, confirmPasswordETSignUp.text.toString())

            setResult(RESULT_OK, returnIntent)
            finish()
        }

    }

    companion object {
        const val NAME_OR_PSEUDO = "name or pseudo"
        const val CONFIRM_PASSWORD = "confirm password"
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}
