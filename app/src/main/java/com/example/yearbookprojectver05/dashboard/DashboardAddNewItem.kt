package com.example.yearbookprojectver05.dashboard

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
import com.example.yearbookprojectver05.R
import com.example.yearbookprojectver05.databinding.ActivityDashboardAddNewItemBinding
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

class DashboardAddNewItem : AppCompatActivity() {

    lateinit var binding : ActivityDashboardAddNewItemBinding
    var dao = DashboardDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardAddNewItemBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAddItemDashboard.setOnClickListener() {
            val itemTitle = binding.etItemTitle.text.toString()
            val itemDescription = binding.etItemDescription.text.toString()

            // Initialized Photo Storage
            val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_sss", Locale.getDefault())
            val now = Date()
            val filenameNewImg = "$itemTitle-img-${formatter.format(now)}"
            val storageReferenceNew = FirebaseStorage.getInstance().getReference("dashboard/$filenameNewImg")
            val imageNew = filenameNewImg


            // Get the data from an ImageView as bytes - For Pic 1
            binding.imgDashboardNewItem.isDrawingCacheEnabled = true
            binding.imgDashboardNewItem.buildDrawingCache()
            val bitmapNew = (binding.imgDashboardNewItem.drawable as BitmapDrawable).bitmap
            val baosNew = ByteArrayOutputStream()
            bitmapNew.compress(Bitmap.CompressFormat.JPEG, 100, baosNew)
            val dataNew = baosNew.toByteArray()

//            // Get the data from an ImageView as bytes - For Pic 2
//            binding.imgGradPic.isDrawingCacheEnabled = true
//            binding.imgGradPic.buildDrawingCache()
//            val bitmapOLd = (binding.imgGradPic.drawable as BitmapDrawable).bitmap
//            val baosOld = ByteArrayOutputStream()
//            bitmapOLd.compress(Bitmap.CompressFormat.JPEG, 100, baosOld)
//            val dataOld = baosOld.toByteArray()

            // Add report to database
            dao.add(
                Dashboard(
                    imageNew, itemTitle,
                    itemDescription)

            )

            // Save photo to database
            storageReferenceNew.putBytes(dataNew)
                .addOnSuccessListener {
                    // Removes photo from imageview
                    binding.imgDashboardNewItem.setImageURI(null)
                    Toast.makeText(applicationContext, "Success!", Toast.LENGTH_SHORT).show()
                }
        }

        binding.btnUpdateItemDashboard.setOnClickListener() {
            updateData()
        }
        binding.btnDeleteItemDashboard.setOnClickListener() {
            deleteData()
        }
//        binding.btnLoadToDashboard.setOnClickListener() {
//            val intent = Intent(this, fragment::class.java)
//            finish()
//            startActivity(intent)
//        }
        binding.imgDashboardNewItem.setOnClickListener() {
            val image = "imageNew"
            showOptions(image)
        }


//        binding.btnLoad.setOnClickListener() {
//            val intent = Intent(this, MySectionActivity::class.java)
//            finish()
//            startActivity(intent)
//        }

    }


    private fun showOptions(imgDashboardNewItem : String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Choose image source")
            .setCancelable(false)
            .setPositiveButton("Open Camera") { dialog, id ->
                showCamera(imgDashboardNewItem)
            }
            .setNegativeButton("Open Gallery") { dialog, id ->
                showGallery(imgDashboardNewItem)
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
                    galleryLauncherNew.launch(galleryIntent)
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
                binding.imgDashboardNewItem.setImageBitmap(image)
            }
        }
    }


    val galleryLauncherNew = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let {
                val selectedImage = result.data?.data
                binding.imgDashboardNewItem.setImageURI(selectedImage)
            }
        }
    }

//    val galleryLauncherOld = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            result.data?.let {
//                val selectedImage = result.data?.data
//                binding.imgGradPic.setImageURI(selectedImage)
//            }
//        }
//    }

    private fun deleteData() {
        dao.remove("")
    }

    private fun updateData() {
    }
}