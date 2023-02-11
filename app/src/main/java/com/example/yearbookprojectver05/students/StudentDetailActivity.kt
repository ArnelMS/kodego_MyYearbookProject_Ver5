package com.example.yearbookprojectver05.students

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yearbookprojectver05.MenuSettingsActivity
import com.example.yearbookprojectver05.databinding.ActivityStudentDetailBinding

class StudentDetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityStudentDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // data from home activity
        var imageProfile:Int = intent.getIntExtra("imageNew",0)
        var imageOld:Int = intent.getIntExtra("imageOld",0)
        var firstName:String? = intent.getStringExtra("firstName")
        var middleName:String? = intent.getStringExtra("middleName")
        var maidenName:String? = intent.getStringExtra("maidenName")
        var lastName:String? = intent.getStringExtra("lastName")
        var mobile:String? = intent.getStringExtra("mobile")
        var email:String? = intent.getStringExtra("email")
        var facebookUrl:String? = intent.getStringExtra("facebookURL")
        var school:String? = intent.getStringExtra("school")
        var batch:String? = intent.getStringExtra("batch")
        var section:String? = intent.getStringExtra("section")

        binding.imgProfileNew.setImageResource(imageProfile)
        binding.imgGradPic.setImageResource(imageOld)
        binding.tvFirstName2.text = firstName
        binding.tvMiddleName2.text = middleName
        binding.tvMaidenName2.text = maidenName
        binding.tvLastName2.text = lastName
        binding.tvMobile2.text = mobile
        binding.tvEmail2.text = email
        binding.tvFacebookUrl2.text = facebookUrl


//        binding.tvFirstName2.text = firstName
//        binding.tvFirstName2.text = firstName
//        binding.tvFirstName2.text = firstName
//        binding.tvFirstName2.text = firstName


    }
}