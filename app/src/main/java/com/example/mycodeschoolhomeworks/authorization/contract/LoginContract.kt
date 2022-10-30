package com.example.mycodeschoolhomeworks.authorization.contract

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.mycodeschoolhomeworks.authorization.activities.LoginActivity

class LoginContract : ActivityResultContract<String, String>() {

    override fun createIntent(context: Context, input: String): Intent {
        val intent = Intent(context, LoginActivity::class.java)
        intent.putExtra("", true)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        return ""
    }

}