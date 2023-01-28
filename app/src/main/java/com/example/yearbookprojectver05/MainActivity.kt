package com.example.yearbookprojectver05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yearbookprojectver05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentOneHome = FragmentOneHome()
        val fragmentTwoDashboard = FragmentTwoAppCompat.FragmentTwoDashboard()
        val fragmentThreeMyYearbook = FragmentThreeMyYearbook()
        val fragmentFourChat = FragmentFourChat()
        val fragmentFiveProfile = FragmentFiveProfile()

        val fragmentZero = FragmentZero()
        val fragmentSixEditProfile = FragmentSixEditProfile()



        supportFragmentManager.beginTransaction().apply {
            replace(binding.frameLayout.id,fragmentOneHome)
            commit()
        }
        binding.btnHome.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.frameLayout.id,fragmentOneHome)
                commit()
            }
        }
        binding.btnDashboard.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.frameLayout.id,fragmentTwoDashboard)
                commit()
            }
        }
        binding.btnMyYearbook.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.frameLayout.id,fragmentThreeMyYearbook)
                commit()
            }
        }
        binding.btnChat.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.frameLayout.id,fragmentFourChat)
                commit()
            }
        }
        binding.btnProfile.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {
                replace(binding.frameLayout.id,fragmentFiveProfile)
                commit()
            }

        }
        binding.btnFragmentZero.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.frameLayout.id, fragmentZero)
                commit()
            }
        }
        binding.btnFragmentSix.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(binding.frameLayout.id, fragmentSixEditProfile)

                commit()
            }
        }

    }
}