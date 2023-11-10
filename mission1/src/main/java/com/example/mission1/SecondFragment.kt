package com.example.mission1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
class SecondFragment : Fragment() {

//    private val viewModel: SharedViewModel by activityViewModels()
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val nameEntered = viewModel.nameEntered.value
//        val phoneEntered = viewModel.phoneEntered.value
//
//        val textView = view.findViewById<TextView>(R.id.thisTextView)
//        textView?.text = "Name: $nameEntered\nPhone: $phoneEntered"
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_second, container, false)
    }
}
