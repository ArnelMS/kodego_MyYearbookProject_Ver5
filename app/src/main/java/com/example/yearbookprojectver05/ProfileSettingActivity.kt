package com.example.yearbookprojectver05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yearbookprojectver05.databinding.ActivityProfileSettingBinding
import com.example.yearbookprojectver05.databinding.FragmentSixEditProfileBinding

class ProfileSettingActivity : AppCompatActivity() {

    lateinit var binding : ActivityProfileSettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding = FragmentSixEditProfileBinding.inflate(layoutInflater)
//        binding.root

        var dao = StudentsDao()

        binding.btnAddProfile.setOnClickListener() {
            dao.add(
                Students(
                    123,
                    123,
                    "Arnel",
                    "Mendoza",
                    "Sebastian",
                    "n/a",
                    99988513,
                    "user1@email.com",
                    "www.facebook.com"))
        }
        binding.btnEditProfile.setOnClickListener(){
            dao.get()
        }
    }
}