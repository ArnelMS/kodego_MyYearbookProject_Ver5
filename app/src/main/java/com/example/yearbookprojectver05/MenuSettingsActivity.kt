package com.example.yearbookprojectver05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yearbookprojectver05.databinding.ActivityMenuSettingsBinding

class MenuSettingsActivity : AppCompatActivity()     {

    lateinit var binding : ActivityMenuSettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvProfileSetting.setOnClickListener() {
            val intent = Intent(this, ProfileSettingActivity::class.java)
            startActivity(intent)
        }
//        binding.tvProfileSetting.setOnClickListener() {
//            supportFragmentManager.beginTransaction().apply {
//                replace(binding.frameLayout.id, fragmentSixEditProfile)
//
//                commit()

//        binding.tvProfileSetting.setOnClickListener() {
//            val intent = Intent(this, fragmentSixEd::class.java)
//            startActivity(intent)

//        }
        binding.tvLogout.setOnClickListener() {
            this.finishAffinity()
        }
    }
}