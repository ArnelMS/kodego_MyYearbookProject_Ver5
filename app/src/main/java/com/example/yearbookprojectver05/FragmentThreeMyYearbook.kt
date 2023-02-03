package com.example.yearbookprojectver05

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yearbookprojectver05.databinding.ActivityMySectionBinding
import com.example.yearbookprojectver05.databinding.FragmentFiveProfileBinding
import com.example.yearbookprojectver05.databinding.FragmentFourChatBinding
import com.example.yearbookprojectver05.databinding.FragmentThreeMyYearbookBinding

class FragmentThreeMyYearbook : Fragment() {

    lateinit var binding: FragmentThreeMyYearbookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeMyYearbookBinding.inflate(layoutInflater)

        val fragmentZero = FragmentZero()

        binding.tvMySection.setOnClickListener() {
            val intent = Intent(context, MySectionActivity::class.java)
            startActivity(intent)

        }
//            val intent = Intent(this, MySectionActivity::class.java)
//            startActivity(intent)

        return binding.root
    }
}