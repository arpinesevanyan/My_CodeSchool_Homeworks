package com.example.mycodeschoolhomeworks.datemefragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.activityViewModels
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.datemefragment.datamodel.DataModel

class LoginFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    private lateinit var loginButtonLF: AppCompatButton
    private lateinit var backButtonLF: AppCompatButton
    private lateinit var emailOrPhoneETLF: EditText
    private lateinit var passwordETLV: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        loginButtonLF = view.findViewById(R.id.loginButtonLF)
        backButtonLF = view.findViewById(R.id.backButtonLF)
        emailOrPhoneETLF = view.findViewById(R.id.emailOrPhoneETLF)
        passwordETLV = view.findViewById(R.id.passwordETLV)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        backButtonLF.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, WelcomeFragment())?.commit()
        }
        loginButtonLF.setOnClickListener {
            dataModel.message.value = emailOrPhoneETLF.toString()
            dataModel.message.value = passwordETLV.toString()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}
