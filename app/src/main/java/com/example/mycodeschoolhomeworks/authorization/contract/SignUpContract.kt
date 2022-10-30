package com.example.mycodeschoolhomeworks.authorization.contract

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.mycodeschoolhomeworks.authorization.activities.SignUpActivity

class SignUpContract: ActivityResultContract<String, String>() {
    override fun createIntent(context: Context, input: String): Intent {
        val intent = Intent(context, SignUpActivity::class.java)
        intent.putExtra("", true)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        TODO("Not yet implemented")
    }
}