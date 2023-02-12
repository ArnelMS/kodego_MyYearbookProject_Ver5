package com.example.yearbookprojectver05

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yearbookprojectver05.Fragment01_Home.FragmentOneHome
import com.example.yearbookprojectver05.Fragment03_MyYearbook.FragmentThreeMyYearbook
import com.example.yearbookprojectver05.Fragment04_Chat.FragmentFourChat
import com.example.yearbookprojectver05.Fragment05_Profile.FragmentFiveProfile
import com.example.yearbookprojectver05.databinding.ActivityMainBinding
import com.example.yearbookprojectver05.databinding.CustomDialog01Binding
import com.example.yearbookprojectver05.ui.dashboard.DashboardFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var uid : String
    private lateinit var email : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uid = intent.getStringExtra("auth").toString()
        email = intent.getStringExtra("email").toString()
        val fragmentOneHome = FragmentOneHome()
        val fragmentTwoDashboard = DashboardFragment.FragmentTwoDashboard()
        val fragmentThreeMyYearbook = FragmentThreeMyYearbook()
        val fragmentFourChat = FragmentFourChat()
        val fragmentFiveProfile = FragmentFiveProfile()

//        val fragment = MyFragment()
//        val bundle = Bundle()
//        bundle.putString("key","value")
//        fragment.arguments = bundle

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

        binding.btnMenu.setOnClickListener() {
            val intent = Intent(this, MenuSettingsActivity::class.java)
            intent.putExtra("auth",uid)
            intent.putExtra("email",email)
            startActivity(intent)
//        }
//            showCustomDialog()
//            Toast.makeText(applicationContext,"MENU", Toast.LENGTH_SHORT).show()
        }

    }

    private fun showCustomDialog() {
        val customDialog : Dialog = Dialog(this)
        val dialogBinding: CustomDialog01Binding = CustomDialog01Binding.inflate(layoutInflater)
        customDialog.setContentView(dialogBinding.root)

        customDialog.show()
    }
}

//  DELETED
//        binding.btnFragmentSix.setOnClickListener() {
//            supportFragmentManager.beginTransaction().apply {
//                replace(binding.frameLayout.id, fragmentSixEditProfile)
//
//                commit()
//            }
//        }