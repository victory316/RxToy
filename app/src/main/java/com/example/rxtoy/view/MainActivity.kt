package com.example.rxtoy.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxtoy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.pianoButton.setOnClickListener {
            startActivity(Intent(this, PianoActivity::class.java))
        }
        
        binding.rxViewButton.setOnClickListener {
            startActivity(Intent(this, RxViewActivity::class.java))
        }
    }
}
