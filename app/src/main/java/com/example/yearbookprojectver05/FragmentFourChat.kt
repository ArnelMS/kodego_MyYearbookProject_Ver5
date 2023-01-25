package com.example.yearbookprojectver05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yearbookprojectver05.databinding.FragmentFourChatBinding

class FragmentFourChat : Fragment() {

    lateinit var binding: FragmentFourChatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFourChatBinding.inflate(layoutInflater)
        return binding.root
      }
}