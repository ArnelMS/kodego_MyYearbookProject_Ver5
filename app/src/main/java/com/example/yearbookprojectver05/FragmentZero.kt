package com.example.yearbookprojectver05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.yearbookprojectver05.databinding.FragmentZeroBinding

class FragmentZeroAppCompat : AppCompatActivity(){
}
class FragmentZero : Fragment() {

    lateinit var binding: FragmentZeroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):
            View? {
        binding = FragmentZeroBinding.inflate(layoutInflater)
        var textFromParent = arguments?.getString("data1")
        binding.tvSampleClick.text = textFromParent
        binding.tvSampleClick.setOnClickListener(){

        }

        return binding.root
    }
}