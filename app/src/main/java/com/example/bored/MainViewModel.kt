package com.example.bored

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    val activity : MutableLiveData<String> by lazy { MutableLiveData<String>() }

}