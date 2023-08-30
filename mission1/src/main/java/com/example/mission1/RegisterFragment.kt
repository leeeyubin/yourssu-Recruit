package com.example.mission1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.mission1.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RegisterFragment : Fragment(){

    private lateinit var binding : FragmentRegisterBinding
    private lateinit var nameEditText : EditText
    private lateinit var phoneEditText : EditText
    private lateinit var registerButton : Button

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false )
        nameEditText = binding.root.findViewById(R.id.nameEditText)
        phoneEditText = binding.root.findViewById(R.id.phoneEditText)
        registerButton = binding.root.findViewById(R.id.registerButton)

        binding.checkTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_registerFragment_to_checkFragment)
        }

        auth = FirebaseAuth.getInstance()

        registerButton.setOnClickListener {

            registerButton.setOnClickListener {
                val name = nameEditText.text.toString()
                val phoneNumber = phoneEditText.text.toString()

                val database = Firebase.database
                val myRef = database.getReference("User")

                val contact = Contact(name, phoneNumber)

                myRef.push().setValue(contact)
                    .addOnSuccessListener {
                        Toast.makeText(requireContext(), "등록 성공", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(requireContext(), "등록 실패: ${e.message}", Toast.LENGTH_LONG).show()
                    }
            }


        }

        return binding.root
    }

}