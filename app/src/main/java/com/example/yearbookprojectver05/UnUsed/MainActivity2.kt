package com.example.yearbookprojectver05.UnUsed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yearbookprojectver05.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}