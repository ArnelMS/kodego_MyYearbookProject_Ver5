package com.example.yearbookprojectver05.dashboards

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.yearbookprojectver05.MySectionActivity
import com.example.yearbookprojectver05.R
import com.example.yearbookprojectver05.databinding.ActivityDashboardSetting2Binding
import com.example.yearbookprojectver05.students.Dashboards2
import com.example.yearbookprojectver05.students.Dashboards2Dao
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

class DashboardSettingActivity2 : AppCompatActivity() {

    lateinit var binding : ActivityDashboardSetting2Binding
    var dao = Dashboards2Dao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardSetting2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAddProfile.setOnClickListener() {

            val firstName = binding.etFirstName.text.toString()
            val middleName = binding.etMiddleName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val maidenName = binding.etMaidenName.text.toString()
            val mobile = binding.etMobile.text.toString()
            val email = binding.etEmail.text.toString()
            val facebookURL = binding.etFacebookURL.text.toString()
            val school = binding.etSchool.text.toString()
            val batch = binding.etFacebookURL.text.toString()
            val section = binding.etFacebookURL.text.toString()


            // Initialized Photo Storage
            val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_sss", Locale.getDefault())
            val now = Date()
            val filenameNew = "$lastName-new-${formatter.format(now)}"
            val filenameOld = "$lastName-old-${formatter.format(now)}"
            val storageReferenceNew = FirebaseStorage.getInstance().getReference("images/$filenameNew")
            val storageReferenceOld = FirebaseStorage.getInstance().getReference("images/$filenameOld")

            val imageNew = filenameNew
            val imageOld = filenameOld


            // Get the data from an ImageView as bytes - For Pic 1
            binding.imgProfileNew.isDrawingCacheEnabled = true
            binding.imgProfileNew.buildDrawingCache()
            val bitmapNew = (binding.imgProfileNew.drawable as BitmapDrawable).bitmap
            val baosNew = ByteArrayOutputStream()
            bitmapNew.compress(Bitmap.CompressFormat.JPEG, 100, baosNew)
            val dataNew = baosNew.toByteArray()

            // Get the data from an ImageView as bytes - For Pic 2
            binding.imgGradPic.isDrawingCacheEnabled = true
            binding.imgGradPic.buildDrawingCache()
            val bitmapOLd = (binding.imgGradPic.drawable as BitmapDrawable).bitmap
            val baosOld = ByteArrayOutputStream()
            bitmapOLd.compress(Bitmap.CompressFormat.JPEG, 100, baosOld)
            val dataOld = baosOld.toByteArray()

            // Add report to database
            dao.add(
                Dashboards2(
                    imageNew, imageOld,
                    firstName,
                    middleName,
                    lastName,
                    maidenName,
                    mobile,
                    email,
                    facebookURL,
                    school,
                    batch,
                    section
                )
            )

            // Save photo to database
            storageReferenceNew.putBytes(dataNew)
                .addOnSuccessListener {
                    // Removes photo from imageview
                    binding.imgProfileNew.setImageURI(null)
                }


            storageReferenceOld.putBytes(dataOld)
                .addOnSuccessListener {
                    // Removes photo from imageview
                    binding.imgGradPic.setImageURI(null)
                }

            Toast.makeText(applicationContext, "Success!", Toast.LENGTH_SHORT).show()
        }



        binding.btnUpdate.setOnClickListener() {
            updateData()
        }
        binding.btnDeleteProfile.setOnClickListener() {
            deleteData()
        }
        binding.imgProfileNew.setOnClickListener() {
            val image = "imageNew"
            showOptions(image)
        }
        binding.imgGradPic.setOnClickListener() {
            val image = "imageGrad"
            showOptions(image)
        }

        binding.btnLoad.setOnClickListener() {
            val intent = Intent(this, MySectionActivity::class.java)
            finish()
            startActivity(intent)
        }

    }


    private fun showOptions(imageView : String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Choose image source")
            .setCancelable(false)
            .setPositiveButton("Open Camera") { dialog, id ->
                showCamera(imageView)
            }
            .setNegativeButton("Open Gallery") { dialog, id ->
                showGallery(imageView)
            }

        val alert = builder.create()
        alert.show()
    }
    // GALLERY LAUNCHER
    private fun showGallery(imageGallery: String) {
        Dexter.withContext(this).withPermission(
            Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object : PermissionListener {
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                if(imageGallery == "imageNew") {
                    galleryLauncherNew.launch(galleryIntent)
                } else {
                    galleryLauncherOld.launch(galleryIntent)
                }

            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                gotoSettings()

            }

            override fun onPermissionRationaleShouldBeShown(
                request: PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

        }).onSameThread().check()
    }

    // CAMERA LAUNCHER
    private fun showCamera(imageCamera : String) {
        Dexter.withContext(this).withPermission(
            Manifest.permission.CAMERA
        ).withListener(object : PermissionListener {
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(cameraIntent)

                if(imageCamera == "imageNew") {
                    cameraLauncherNew.launch(cameraIntent)
                } else {
                    cameraLauncherOld.launch(cameraIntent)
                }
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                gotoSettings()
            }

            override fun onPermissionRationaleShouldBeShown(
                request: PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }
        }).onSameThread().check()
    }
    private fun gotoSettings() {
        AlertDialog.Builder(this)
            .setMessage("It seems your permission has been denied. Got to settings")
            .setPositiveButton("Go to Settings") { dialog, item ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                var uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            }.setNegativeButton("Cancel") { dialog, item ->
                dialog.dismiss()
            }.show()
    }

    val cameraLauncherNew = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.extras.let {
                val image: Bitmap = result.data?.extras?.get("data") as Bitmap
                binding.imgProfileNew.setImageBitmap(image)
            }
        }
    }

    val cameraLauncherOld = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.extras.let {
                val image: Bitmap = result.data?.extras?.get("data") as Bitmap
                binding.imgGradPic.setImageBitmap(image)
            }
        }
    }

    val galleryLauncherNew = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let {
                val selectedImage = result.data?.data
                binding.imgProfileNew.setImageURI(selectedImage)
            }
        }
    }

    val galleryLauncherOld = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let {
                val selectedImage = result.data?.data
                binding.imgGradPic.setImageURI(selectedImage)
            }
        }
    }

    private fun deleteData() {
        dao.remove("-NNHtXcN04nN9t2s-oCm")
    }

    private fun updateData() {
    }
}