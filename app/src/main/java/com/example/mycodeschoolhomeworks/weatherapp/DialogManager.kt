package com.example.mycodeschoolhomeworks.weatherapp

import android.content.Context
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

object DialogManager {
    fun locationSettingsDialog(context: Context, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle("Enabled location?")
        dialog.setMessage("Location disabled, do you want enable location?")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ok") { _, _ ->
            listener.onClick(null)
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel") { _, _ ->
            dialog.dismiss()
        }
        dialog.show()
    }

    fun searchByNameDialog(context: Context, listener: Listener) {
        val builder = AlertDialog.Builder(context)
        val editName = EditText(context)
        builder.setView(editName)
        val dialog = builder.create()
        dialog.setTitle("City Name: ")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ok") { _, _ ->
            listener.onClick(editName.text.toString())
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel") { _, _ ->
            dialog.dismiss()
        }
        dialog.show()
    }

    interface Listener {
        fun onClick(name: String?)
    }
}