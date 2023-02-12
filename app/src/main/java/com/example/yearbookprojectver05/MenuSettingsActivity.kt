package com.example.yearbookprojectver05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yearbookprojectver05.Fragment04_Chat.FragmentFourChat
import com.example.yearbookprojectver05.dashboard.DashboardAddNewItem
import com.example.yearbookprojectver05.dashboard.DashboardItemViewActivity
import com.example.yearbookprojectver05.databinding.ActivityMenuSettingsBinding
import com.example.yearbookprojectver05.databinding.FragmentHomeBinding

class MenuSettingsActivity : AppCompatActivity()     {

    lateinit var binding : ActivityMenuSettingsBinding
    private lateinit var uid : String
    private lateinit var email : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uid = intent.getStringExtra("auth").toString()
        email = intent.getStringExtra("email").toString()

        binding.tvHomeSetting.setOnClickListener() {
            val intent = Intent(this, FragmentHomeBinding::class.java)
            startActivity(intent)
        }
        binding.tvNewItemDashboard.setOnClickListener() {
            val intent = Intent(this, DashboardAddNewItem::class.java)
            startActivity(intent)
        }

        binding.tvMyYearbookSetting.setOnClickListener() {
            val intent = Intent(this, ProfileSettingActivity::class.java)
            startActivity(intent)
        }
        binding.tvChatSetting.setOnClickListener() {
            val intent = Intent(this, FragmentFourChat::class.java)
            startActivity(intent)
        }
        binding.tvProfileSetting.setOnClickListener() {
            val intent = Intent(this, ProfileSettingActivity::class.java)
            intent.putExtra("auth",uid)
            intent.putExtra("email",email)
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