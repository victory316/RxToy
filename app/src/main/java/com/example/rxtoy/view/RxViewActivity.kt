package com.example.rxtoy.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxtoy.R
import com.example.rxtoy.databinding.ActivityRxViewBinding

class RxViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRxViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRxViewBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}
