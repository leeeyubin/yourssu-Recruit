package com.example.mission1
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class RegisterFragment : Fragment() {

    private lateinit var nameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var registerButton: Button

    val contactList = mutableListOf<Contact>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        nameEditText = view.findViewById(R.id.nameEditText)
        phoneEditText = view.findViewById(R.id.phoneEditText)
        registerButton = view.findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val phone = phoneEditText.text.toString()

            if (name.isNotEmpty() && phone.isNotEmpty()) {
                val contact = Contact(name, phone)
                contactList.add(contact)
                showToast("등록되었습니다")
            } else {
                showToast("이름과 전화번호를 모두 입력해주세요")
            }
        }

        return view
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun clearInputFields() {
        nameEditText.text.clear()
        phoneEditText.text.clear()
    }

    interface OnContactAddedListener {
        fun onContactAdded(contact: Contact)
    }

    private var listener: OnContactAddedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnContactAddedListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    data class Contact(val name: String, val phone: String)
}