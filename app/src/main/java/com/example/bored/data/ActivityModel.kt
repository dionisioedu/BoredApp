package com.example.bored.data

//{"activity":"Host a movie marathon with some friends","type":"social","participants":3,"price":0.1,"link":"","key":"5914292","accessibility":0}

data class ActivityModel(
    val activity: String,
    val type: String,
    val participants: Int,
    val price: Double,
    val link: String,
    val key: String,
    val acessibility: Int,
)