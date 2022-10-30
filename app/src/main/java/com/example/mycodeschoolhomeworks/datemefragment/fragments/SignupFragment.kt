package com.example.mycodeschoolhomeworks.datemefragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.mycodeschoolhomeworks.R
import com.example.mycodeschoolhomeworks.datemefragment.datamodel.DataModel

class SignupFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    private lateinit var signUpButtonSF: AppCompatButton
    private lateinit var backButtonSF: AppCompatButton
    private lateinit var emailOrPhoneETSF: EditText
    private lateinit var passwordETSF: EditText
    private lateinit var confirmPasswordETSF: EditText
    private lateinit var nameETSF: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_signup, container, false)

        signUpButtonSF = view.findViewById(R.id.signUpButtonSF)
        backButtonSF = view.findViewById(R.id.backButtonSF)
        emailOrPhoneETSF = view.findViewById(R.id.emailOrPhoneETSF)
        passwordETSF = view.findViewById(R.id.passwordETSF)
        confirmPasswordETSF = view.findViewById(R.id.confirmPasswordETSF)
        nameETSF = view.findViewById(R.id.nameETSF)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        backButtonSF.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, WelcomeFragment())?.commit()
        }
        signUpButtonSF.setOnClickListener {
            dataModel.message.observe(activity as LifecycleOwner, {
                emailOrPhoneETSF.text.toString()
                passwordETSF.text.toString()
                confirmPasswordETSF.text.toString()
                nameETSF.text.toString()
            })
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SignupFragment()
    }
}