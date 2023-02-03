package com.example.yearbookprojectver05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.yearbookprojectver05.databinding.FragmentSixEditProfileBinding

class FragmentSixEditProfile : Fragment() {

    lateinit var binding: FragmentSixEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentSixEditProfileBinding.inflate(layoutInflater)
        binding.root

        var dao = StudentsDao()

        binding.btnSave.setOnClickListener() {
            dao.add(
                Students(
                    123,
                    123,
                    "Arnel",
                    "Mendoza",
                    "Sebastian",
                    "n/a",
                    99988513,
                    "user1@email.com",
                    "www.facebook.com"))

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_six_edit_profile, container, false)
    }
}