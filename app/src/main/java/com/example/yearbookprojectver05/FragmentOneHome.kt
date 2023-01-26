package com.example.yearbookprojectver05

import android.app.backup.BackupDataInput
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yearbookprojectver05.databinding.FragmentOneHomeBinding

class FragmentOneHome : Fragment() {

    lateinit var binding: FragmentOneHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOneHomeBinding.inflate(layoutInflater)
        return binding.root
    }
}