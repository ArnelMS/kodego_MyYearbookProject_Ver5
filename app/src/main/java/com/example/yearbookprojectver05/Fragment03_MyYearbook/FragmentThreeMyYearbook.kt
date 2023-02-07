package com.example.yearbookprojectver05.Fragment03_MyYearbook

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yearbookprojectver05.MySectionActivity
import com.example.yearbookprojectver05.databinding.FragmentThreeMyYearbookBinding

class FragmentThreeMyYearbook : Fragment() {

    lateinit var binding: FragmentThreeMyYearbookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeMyYearbookBinding.inflate(layoutInflater)


        binding.tvMySection.setOnClickListener() {
            val intent = Intent(context, MySectionActivity::class.java)
            startActivity(intent)

        }

        return binding.root
    }
}