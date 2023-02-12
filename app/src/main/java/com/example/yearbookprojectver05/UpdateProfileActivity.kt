package com.example.yearbookprojectver05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.yearbookprojectver05.databinding.ActivityUpdateProfileBinding

class UpdateProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityUpdateProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdateProfile.setOnClickListener(){
            Toast.makeText(applicationContext, "Profile Updated", Toast.LENGTH_LONG).show()
       }
        binding.btnBackDashboard.setOnClickListener(){
            Toast.makeText(applicationContext, "HOME", Toast.LENGTH_LONG).show()
        }

    }
}