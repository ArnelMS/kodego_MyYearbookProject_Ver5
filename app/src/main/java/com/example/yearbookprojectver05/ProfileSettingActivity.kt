package com.example.yearbookprojectver05

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.yearbookprojectver05.databinding.ActivityProfileSettingBinding
import com.example.yearbookprojectver05.students.Students
import com.example.yearbookprojectver05.students.StudentsDao
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import java.io.ByteArrayOutputStream
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ProfileSettingActivity : AppCompatActivity() {

    lateinit var binding : ActivityProfileSettingBinding
    var dao = StudentsDao()
    private lateinit var uid : String
    private lateinit var userEmail : String

    lateinit var id : String
    lateinit var imageNew : String
    lateinit var imageOld : String
    lateinit var firstName : String
    lateinit var middleName : String
    lateinit var maidenName : String
    lateinit var lastName : String
    lateinit var mobile : String
    lateinit var email : String
    lateinit var facebookUrl : String
    lateinit var school : String
    lateinit var batch : String
    lateinit var section : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        uid = intent.getStringExtra("auth").toString()
        userEmail = intent.getStringExtra("email").toString()

        dao.get().addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var students: ArrayList<Students> = ArrayList<Students>()

                var dataFromDb = snapshot.children
                for (data in dataFromDb) {
                    if(uid == data.child("uid").value.toString()) {

                        id = data.key.toString()
                        imageNew = data.child("imageNew").value.toString()
                        imageOld = data.child("imageOld").value.toString()
                        firstName = data.child("firstName").value.toString()
                        middleName = data.child("middleName").value.toString()
                        maidenName = data.child("maidenName").value.toString()
                        lastName = data.child("lastName").value.toString()
                        mobile = data.child("mobile").value.toString()
                        email = userEmail
                        facebookUrl = data.child("facebookURL").value.toString()
                        school = data.child("school").value.toString()
                        batch = data.child("batch").value.toString()
                        section = data.child("section").value.toString()

                        val storageRefNew = FirebaseStorage.getInstance().reference.child("images/$imageNew")
                        val storageRefOld = FirebaseStorage.getInstance().reference.child("images/$imageOld")


                        // For New
                        val localFileNew = File.createTempFile("tempImageNew","jpg")
                        storageRefNew.getFile(localFileNew).addOnSuccessListener {
                            val bitmapNew = BitmapFactory.decodeFile(localFileNew.absolutePath)
                            binding.imgProfileNew.setImageBitmap(bitmapNew)
                        }
                            .addOnFailureListener {
                                binding.imgProfileNew.setImageResource(R.drawable.profile_modern)
                            }

                        // For Old
                        val localFileOld = File.createTempFile("tempImageOld","jpg")
                        storageRefOld.getFile(localFileOld).addOnSuccessListener {
                            val bitmapOld = BitmapFactory.decodeFile(localFileOld.absolutePath)
                            binding.imgGradPic.setImageBitmap(bitmapOld)
                        }
                            .addOnFailureListener {
                                binding.imgGradPic.setImageResource(R.drawable.profile_gradpic)
                            }

                        binding.etFirstName.setText(firstName)
                        binding.etMiddleName.setText(middleName)
                        binding.etMaidenName.setText(maidenName)
                        binding.etLastName.setText(lastName)
                        binding.etMobile.setText(mobile)
                        binding.etEmail.setText(email)
                        binding.etFacebookURL.setText(facebookUrl)
                        binding.etSchool.setText(school)
                        binding.etBatch.setText(batch)
                        binding.etSection.setText(section)

                    } else {

                        binding.etEmail.isEnabled = false

                    }
                }
            }



            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        binding.btnAddProfile.setOnClickListener() {

                val userID = uid
                val firstName = binding.etFirstName.text.toString()
                val middleName = binding.etMiddleName.text.toString()
                val lastName = binding.etLastName.text.toString()
                val maidenName = binding.etMaidenName.text.toString()
                val mobile = binding.etMobile.text.toString()
                val email = binding.etEmail.text.toString()
                val facebookURL = binding.etFacebookURL.text.toString()

                val school = binding.etSchool.text.toString()
                val batch = binding.etBatch.text.toString()
                val section = binding.etSection.text.toString()

            if (id.isEmpty()) {

                // Initialized Photo Storage
                val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_sss", Locale.getDefault())
                val now = Date()
                val filenameNew = "$lastName-new-${formatter.format(now)}"
                val filenameOld = "$lastName-old-${formatter.format(now)}"

                val storageReferenceNew =
                    FirebaseStorage.getInstance().getReference("images/$filenameNew")
                val storageReferenceOld =
                    FirebaseStorage.getInstance().getReference("images/$filenameOld")

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
                    Students(
                        userID,
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
                        binding.imgProfileNew.setImageURI(null) // Removes photo from imageview
                    }


                storageReferenceOld.putBytes(dataOld)
                    .addOnSuccessListener {
                        binding.imgGradPic.setImageURI(null) // Removes photo from imageview
                    }

                Toast.makeText(applicationContext, "Success!", Toast.LENGTH_SHORT).show()

            } else {

                // Update database
                updateData(
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
                    section,id
                )

                val storageReferenceNew =
                    FirebaseStorage.getInstance().getReference("images/$imageNew")
                val storageReferenceOld =
                    FirebaseStorage.getInstance().getReference("images/$imageOld")

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

                // Save photo to database
                storageReferenceNew.putBytes(dataNew)
                    .addOnSuccessListener {
                        binding.imgProfileNew.setImageURI(null) // Removes photo from imageview
                    }


                storageReferenceOld.putBytes(dataOld)
                    .addOnSuccessListener {
                        binding.imgGradPic.setImageURI(null) // Removes photo from imageview
                    }

                Toast.makeText(applicationContext, "Successful Update!", Toast.LENGTH_SHORT).show()


            }
        }



        binding.btnUpdate.setOnClickListener() {
            showBuiltInDialogUpdate()
        }
        binding.btnDeleteProfile.setOnClickListener() {
            showBuiltInDialogDelete()
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

    private fun updateData(
        imageNew : String,
        imageOld: String,
        firstName: String,
        middleName: String,
        lastName: String,
        maidenName: String,
        mobile: String,
        email: String,
        facebookURL: String,
        school: String,
        batch: String,
        section: String,
        userID: String
    ) {
        var mapData = mutableMapOf<String, String>()
        mapData["imageNew"] = imageNew
        mapData["imageOld"] = imageOld
        mapData["firstName"] = firstName
        mapData["middleName"] = middleName
        mapData["lastName"] = lastName
        mapData["maidenName"] = maidenName
        mapData["mobile"] = mobile
        mapData["email"] = email
        mapData["facebookURL"] = facebookURL
        mapData["school"] = school
        mapData["batch"] = batch
        mapData["section"] = section
        dao.update(userID, mapData)
    }
    private fun showBuiltInDialogUpdate() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to Update?")
            .setPositiveButton("YES") { dialog, item ->
                deleteData()
            }.setNegativeButton("Cancel") { dialog, item ->
                dialog.dismiss()
            }.show()
    }

    private fun showBuiltInDialogDelete() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to Delete?")
            .setPositiveButton("YES") { dialog, item ->
                updateData()
            }.setNegativeButton("Cancel") { dialog, item ->
                dialog.dismiss()
            }.show()
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
                val galleryIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
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
        var mapData = mutableMapOf<String,String>()
        mapData["name"]=""
        dao.update("",mapData)
    }
}