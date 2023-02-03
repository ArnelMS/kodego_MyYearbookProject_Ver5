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
            val imageNew = binding.imgProfileNew.toString()
            val imageOld = binding.imgGradPic.toString()
            val firstName = binding.etFirstName.text.toString()
            val middleName = binding.etFirstName.text.toString()
            val lastName = binding.etFirstName.text.toString()
            val maidenName = binding.etFirstName.text.toString()
            val mobile = binding.etFirstName.text.toString()
            val email = binding.etFirstName.text.toString()
            val facebookURL = binding.etFirstName.text.toString()

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