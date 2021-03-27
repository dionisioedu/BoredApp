package com.example.bored

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bored.network.BoreApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel() : ViewModel() {

    private val _activity = MutableLiveData<String>()

    val activity : LiveData<String>
        get() = _activity

    fun getNext() {
        BoreApi.retrofitService.getActivity().enqueue(
            object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    _activity.value = response.body()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    _activity.value = "Error : " + t.message
                }

            }
        )
    }

}