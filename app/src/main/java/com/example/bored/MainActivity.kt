package com.example.bored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.bored.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.apply {
            viewModel.activity.observe(this@MainActivity, Observer {
                textviewActivity.text = it
            })

            buttonBored.let {
                it.setOnClickListener {
                    viewModel.getNext()
                }
            }
        }

        setContentView(binding.root)
    }
}