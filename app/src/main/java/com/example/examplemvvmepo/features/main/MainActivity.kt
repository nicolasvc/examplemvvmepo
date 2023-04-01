package com.example.examplemvvmepo.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examplemvvmepo.R
import com.example.examplemvvmepo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}