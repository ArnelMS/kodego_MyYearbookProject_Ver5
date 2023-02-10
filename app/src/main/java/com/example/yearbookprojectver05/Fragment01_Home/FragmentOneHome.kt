package com.example.yearbookprojectver05.Fragment01_Home

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.startActivity
import com.example.yearbookprojectver05.R
import com.example.yearbookprojectver05.databinding.FragmentOneHomeBinding
import com.example.yearbookprojectver05.databinding.FragmentThreeMyYearbookBinding
import com.google.firebase.storage.FirebaseStorage
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


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
        binding.imgSchoolLogo.setOnClickListener() {
        }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            val batchData =
                arrayListOf<String>("1991", "1992", "1993", "1994", "1995", "1996", "1997",)


            val adapterParent = ArrayAdapter(requireContext(), R.layout.batchtextviewxml, batchData)
            binding.spinnerBatch.adapter = adapterParent

            binding.btnGoToMyYearbook.setOnClickListener() {
                val spinnerItem = binding.spinnerBatch.selectedItem.toString()
                Toast.makeText(context, spinnerItem, Toast.LENGTH_SHORT).show()

            }
            return binding.root
        }
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++