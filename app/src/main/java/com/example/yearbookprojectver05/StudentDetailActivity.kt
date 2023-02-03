package com.example.yearbookprojectver05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yearbookprojectver05.databinding.ActivityStudentDetailBinding

class StudentDetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityStudentDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}