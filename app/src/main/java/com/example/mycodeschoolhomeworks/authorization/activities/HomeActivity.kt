package com.example.mycodeschoolhomeworks.authorization.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.authorization.contract.LoginContract
import com.example.mycodeschoolhomeworks.authorization.contract.SignUpContract

class HomeActivity : AppCompatActivity() {
    lateinit var logInButton: AppCompatButton
    lateinit var signUpButton: AppCompatButton

    private val loginContract = registerForActivityResult(LoginContract()) {

    }
    private val signUpContract = registerForActivityResult(SignUpContract()) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        logInButton = findViewById(R.id.logInButton)
        signUpButton = findViewById(R.id.signUpButton)

        logInButton.setOnClickListener() {
            loginContract.launch("")
        }
        signUpButton.setOnClickListener() {
            signUpContract.launch("")
        }
    }
}