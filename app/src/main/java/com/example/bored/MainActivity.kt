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
                Log.d("Teste", "Texto atualizado : $it")
            })

            viewModel.activity.value = "Nothing to do?"

            buttonBored?.let {
                it.setOnClickListener {
                    viewModel.activity.value = "Clicked!"
                    Log.d("Teste", "Button Clicked!")
                }
            }
        }

        setContentView(binding.root)
    }
}