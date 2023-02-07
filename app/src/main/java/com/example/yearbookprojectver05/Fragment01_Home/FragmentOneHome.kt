package com.example.yearbookprojectver05.Fragment01_Home

import android.app.backup.BackupDataInput
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.yearbookprojectver05.R
import com.example.yearbookprojectver05.databinding.FragmentOneHomeBinding

class FragmentOneHome : Fragment() {

    lateinit var binding: FragmentOneHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentOneHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        binding.root


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOneHomeBinding.inflate(layoutInflater)
        return binding.root
    }

//        val batchdata = arrayListOf<String>("1991", "1992", "1993", "1994", "1995", "1996", "1997",)
//        val adapterParent = ArrayAdapter(requireContext(), R.layout.batchtextviewxml, batchdata)
//        binding.spinnerBatch.adapter = adapterParent }

}