package com.example.mycodeschoolhomeworks.contract

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.contract.LoginActivity.Companion.PASSWORD
import com.example.mycodeschoolhomeworks.contract.LoginActivity.Companion.USER_NAME

class HomeActivity : AppCompatActivity() {
    lateinit var logInButton: AppCompatButton
    lateinit var signUpButton: AppCompatButton

    private var loginResult: ActivityResultLauncher<Intent>? = null
    private var signUpResult: ActivityResultLauncher<Intent>? = null

    private val contract =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
            if (result?.resultCode == Activity.RESULT_OK) {


            } else {

            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loginResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    val username = result.data?.getStringExtra(USER_NAME)
                    val password = result.data?.getStringExtra(PASSWORD)
                    Log.d("My Log", "username: $username password: $password")
                    Dialog(this@HomeActivity, R.style.CustomAlertDialog).apply {
                        setContentView(R.layout.name_password_dialog)
                        findViewById<TextView>(R.id.passwordTextView2).text = "password: $password"
                        findViewById<TextView>(R.id.emailOrPhoneTextView2).text =
                            "username: $username"
                        findViewById<TextView>(R.id.confirmPasswordTextView).isVisible = false
                        findViewById<TextView>(R.id.nameOrPseudoTextView).isVisible = false
                    }.show()
                }
            }
        signUpResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    val username = result.data?.getStringExtra(USER_NAME)
                    val password = result.data?.getStringExtra(PASSWORD)
                    val confirmPassword =
                        result.data?.getStringExtra(SignUpActivity.CONFIRM_PASSWORD)
                    val nameOrPseudo = result.data?.getStringExtra(SignUpActivity.NAME_OR_PSEUDO)

                    Dialog(this@HomeActivity, R.style.CustomAlertDialog).apply {
                        setContentView(R.layout.name_password_dialog)
                        findViewById<TextView>(R.id.passwordTextView2).text = "password: $password"
                        findViewById<TextView>(R.id.emailOrPhoneTextView2).text =
                            "username: $username"
                        findViewById<TextView>(R.id.confirmPasswordTextView).text =
                            "confirm password: $confirmPassword"
                        findViewById<TextView>(R.id.nameOrPseudoTextView).text =
                            "name Or Pseudo: $nameOrPseudo"
                    }.show()
                }
            }


        logInButton = findViewById(R.id.logInButton)
        signUpButton = findViewById(R.id.signUpButton)

        logInButton.setOnClickListener() {
            val intent = Intent(this, LoginActivity::class.java)
            contract.launch(intent)
        }
        signUpButton.setOnClickListener() {
            val intent = Intent(this, SignUpActivity::class.java)
            contract.launch(intent)
        }
    }
}