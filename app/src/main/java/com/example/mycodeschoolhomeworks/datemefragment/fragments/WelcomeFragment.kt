package com.example.mycodeschoolhomeworks.datemefragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.mycodeschoolhomeworks.R

class WelcomeFragment : Fragment() {

    private lateinit var logInButton: AppCompatButton
    private lateinit var signUpButton: AppCompatButton
    var output: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        logInButton = view.findViewById(R.id.logInButton)
        signUpButton = view.findViewById(R.id.signUpButton)

        val message: TextView = view.findViewById(R.id.messageData)
        output = arguments?.getString("message")
        message.text = output
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        logInButton.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, LoginFragment())?.commit()
        }
        signUpButton.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, SignupFragment())?.commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = WelcomeFragment()
    }
}
