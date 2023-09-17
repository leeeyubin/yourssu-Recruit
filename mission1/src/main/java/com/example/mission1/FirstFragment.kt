package com.example.mission1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mission1.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()
    private var binding: FragmentFirstBinding? = null
    private lateinit var nameEditText: EditText
    private lateinit var phoneEditText: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding?.root

        nameEditText = binding?.root?.findViewById(R.id.nameEditText) ?: EditText(context)
        phoneEditText = binding?.root?.findViewById(R.id.phoneEditText) ?: EditText(context)

        binding?.registerBtn?.setOnClickListener{
            val nameEntered = nameEditText.text.toString()
            val phoneEntered = phoneEditText.text.toString()

            if(nameEntered.isEmpty() || phoneEntered.isEmpty()){
                Toast.makeText(context, "이름과 전화번호를 모두 입력하세요", Toast.LENGTH_LONG).show()
            } else {
                // ViewModel에 값을 설정
                viewModel.setNameEntered(nameEntered)
                viewModel.setPhoneEntered(phoneEntered)
                Toast.makeText(context, "등록 성공", Toast.LENGTH_LONG).show()
            }
        }

        return view
    }
}
