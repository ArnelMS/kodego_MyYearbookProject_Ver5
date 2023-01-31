package com.example.yearbookprojectver05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.yearbookprojectver05.databinding.FragmentFiveProfileBinding

class FragmentFiveProfile : Fragment() {


    lateinit var binding: FragmentFiveProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentFiveProfileBinding.inflate(layoutInflater)

        return binding.root

    }

}