package com.example.mission1


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    private val _nameEntered = MutableLiveData<String>()
    val nameEntered: LiveData<String> get() = _nameEntered

    private val _phoneEntered = MutableLiveData<String>()
    val phoneEntered: LiveData<String> get() = _phoneEntered

    fun setNameEntered(name: String) {
        _nameEntered.value = name
    }

    fun setPhoneEntered(phone: String) {
        _phoneEntered.value = phone
    }
}