package com.example.yearbookprojectver05.Trash

import com.example.yearbookprojectver05.databinding.ActivityMain4Binding

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.yearbookprojectver05.MySectionActivity
import com.example.yearbookprojectver05.students.Dashboards2Dao
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.util.HashMap

class MainActivity4 : AppCompatActivity() {


        lateinit var binding : ActivityMain4Binding
        private lateinit var progressDialog : ProgressDialog
        private lateinit var auth : FirebaseAuth
        private lateinit var storage : FirebaseStorage
        private lateinit var database : FirebaseDatabase
        private lateinit var selectedImage : Uri
        var dao = Dashboards2Dao()



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMain4Binding.inflate(layoutInflater)
            setContentView(binding.root)
            //init
            auth = FirebaseAuth.getInstance()
            storage = FirebaseStorage.getInstance()
            database = FirebaseDatabase.getInstance()

            progressDialog = ProgressDialog(this)
            progressDialog.setTitle("PLease wait")
            progressDialog.setCanceledOnTouchOutside(false)



            binding.btnAddProfile.setOnClickListener() {

                val batch = binding.etFacebookURL.text.toString()

                if (batch == "batch 1"){
                    addNewData1()
                }else if (batch == "batch 2"){
                    addNewData2()
                }else if (batch == "batch 3"){
                    //   addNewData3()
                }else if (batch == "batch 4"){
                    //    addNewData4()
                }
            }

            binding.btnUpdate.setOnClickListener() {

            }
            //delete
            binding.btnDeleteProfile.setOnClickListener() {

            }

            //grad pic only
            binding.imgGradPic.setOnClickListener() {
                val intent = Intent()
                intent.action = Intent.ACTION_GET_CONTENT
                intent.type = "image/*"
                startActivityForResult(intent,1)
            }

            binding.btnLoad.setOnClickListener() {
                val intent = Intent(this, MySectionActivity::class.java)
                finish()
                startActivity(intent)
            }


        }

        private fun addNewData2() {
            progressDialog.setMessage("Uploading Image...")
            progressDialog.show()
            val uid = auth.uid


            val reference = storage.reference.child("Batch2 Profile")
                .child(uid!!)
            reference.putFile(selectedImage).addOnCompleteListener{
                if (it.isSuccessful){
                    reference.downloadUrl.addOnSuccessListener {task->
                        uploadInfo2(task.toString())
                    }
                }
            }

        }

        private fun uploadInfo2(Img: String) {
            progressDialog.setMessage("Saving Account...")
            progressDialog.show()
            val firstName = binding.etFirstName.text.toString()
            val middleName = binding.etMiddleName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val maidenName = binding.etMaidenName.text.toString()
            val mobile = binding.etMobile.text.toString()
            val email = binding.etEmail.text.toString()
            val facebookURL = binding.etFacebookURL.text.toString()
            val batch = binding.etFacebookURL.text.toString()
            val section = binding.etFacebookURL.text.toString()


            val timestamp = System.currentTimeMillis()
            val uid = auth.uid
            val hashMap : HashMap<String, Any?> = HashMap()

            hashMap["uid"] = uid
            hashMap["email"] = email
            hashMap["firstName"] = firstName
            hashMap["middleName"] = middleName
            hashMap["lastName"] = lastName
            hashMap["maidenName"] = maidenName
            hashMap["mobile"] = mobile
            hashMap["facebookURL"] = facebookURL
            hashMap["id"] = "$timestamp"
            hashMap["batch"] = batch
            hashMap["section"] = section
            hashMap["imageNew"] = Img


            database.getReference("Batch 2")
                .child(FirebaseAuth.getInstance().currentUser!!.uid)
                .setValue(hashMap)
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        progressDialog.dismiss()

                        Toast.makeText(this,"Account Created", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this,it.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                }


        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (data != null){
                if (data.data != null){
                    selectedImage = data.data!!
                    binding.imgGradPic.setImageURI(selectedImage)
                }
            }
        }


        private fun addNewData1() {
            progressDialog.setMessage("Uploading Image...")
            progressDialog.show()
            val uid = auth.uid


            val reference = storage.reference.child("Batch1 Profile")
                .child(uid!!)
            reference.putFile(selectedImage).addOnCompleteListener{
                if (it.isSuccessful){
                    reference.downloadUrl.addOnSuccessListener {task->
                        uploadInfo(task.toString())
                    }
                }
            }




        }

        private fun uploadInfo(Img: String) {
            progressDialog.setMessage("Saving Account...")
            progressDialog.show()
            val firstName = binding.etFirstName.text.toString()
            val middleName = binding.etMiddleName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val maidenName = binding.etMaidenName.text.toString()
            val mobile = binding.etMobile.text.toString()
            val email = binding.etEmail.text.toString()
            val facebookURL = binding.etFacebookURL.text.toString()
            val batch = binding.etFacebookURL.text.toString()
            val section = binding.etFacebookURL.text.toString()


            val timestamp = System.currentTimeMillis()
            val uid = auth.uid
            val hashMap : HashMap<String, Any?> = HashMap()

            hashMap["uid"] = uid
            hashMap["email"] = email
            hashMap["firstName"] = firstName
            hashMap["middleName"] = middleName
            hashMap["lastName"] = lastName
            hashMap["maidenName"] = maidenName
            hashMap["mobile"] = mobile
            hashMap["facebookURL"] = facebookURL
            hashMap["id"] = "$timestamp"
            hashMap["batch"] = batch
            hashMap["section"] = section
            hashMap["imageNew"] = Img


            database.getReference("Batch 1")
                .child(FirebaseAuth.getInstance().currentUser!!.uid)
                .setValue(hashMap)
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        progressDialog.dismiss()

                        Toast.makeText(this,"Account Created", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this,it.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                }


        }


    }
