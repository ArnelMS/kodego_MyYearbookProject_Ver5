package com.example.yearbookprojectver05.Trash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.yearbookprojectver05.R
import com.example.yearbookprojectver05.databinding.ActivityMain2Binding
import com.example.yearbookprojectver05.databinding.ActivityMain3Binding
import com.example.yearbookprojectver05.databinding.FragmentOneHomeBinding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: FragmentOneHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentOneHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val batchdata = arrayListOf<String>("1991", "1992", "1993", "1994", "1995", "1996", "1997",)
        val adapterParent = ArrayAdapter(applicationContext, R.layout.batchtextviewxml, batchdata)

        binding.spinnerBatch.adapter = adapterParent
    }


}