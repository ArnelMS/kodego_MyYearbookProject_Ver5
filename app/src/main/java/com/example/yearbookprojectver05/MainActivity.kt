package com.example.yearbookprojectver05

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.yearbookprojectver05.databinding.ActivityMainBinding
import com.example.yearbookprojectver05.databinding.CustomDialog01Binding

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

        binding.btnMenuDialog.setOnClickListener() {
            showCustomDialog()
            Toast.makeText(applicationContext,"MENU", Toast.LENGTH_SHORT).show()
        }

    }

    private fun showCustomDialog() {
        val customDialog : Dialog = Dialog(this)
        val dialogBinding: CustomDialog01Binding = CustomDialog01Binding.inflate(layoutInflater)
        customDialog.setContentView(dialogBinding.root)

        customDialog.show()


    }
}