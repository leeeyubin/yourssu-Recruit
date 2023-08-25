package com.example.mission1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ViewContactsFragment : Fragment() {

    private lateinit var listView: ListView
    private val contacts = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_contacts, container, false)

        listView = view.findViewById(R.id.contactsListView)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            contacts
        )
        listView.adapter = adapter

        return view
    }

    fun updateContactList(contact: RegisterFragment.Contact) {
        val contactText = "${contact.name}\n번호: ${contact.phone}"
        contacts.add(contactText)
        (listView.adapter as ArrayAdapter<*>).notifyDataSetChanged()
    }
}