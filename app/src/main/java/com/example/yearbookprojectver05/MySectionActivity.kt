package com.example.yearbookprojectver05

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yearbookprojectver05.databinding.ActivityMySectionBinding
import com.example.yearbookprojectver05.databinding.ActivityStudentDetailBinding
import com.example.yearbookprojectver05.students.StudentAdapter
import com.example.yearbookprojectver05.students.StudentDetailActivity
import com.example.yearbookprojectver05.students.Students
import com.example.yearbookprojectver05.students.StudentsDao
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class MySectionActivity : AppCompatActivity() {


    lateinit var binding : ActivityMySectionBinding
    var dao = StudentsDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMySectionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        view()
    }

    private fun view() {
        dao.get().addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var students: ArrayList<Students> = ArrayList<Students>()

                var dataFromDb = snapshot.children
//                Toast.makeText(applicationContext, ""+dataFromDb, Toast.LENGTH_SHORT).show()

                for (data in dataFromDb) {
                    var id = data.key.toString()
                    var userID = data.child("imageNew").value.toString()
                    var imageProfile = data.child("imageNew").value.toString()
                    var imageOld = data.child("imageOld").value.toString()
                    var firstName = data.child("firstName").value.toString()
                    var middleName = data.child("middleName").value.toString()
                    var maidenName = data.child("maidenName").value.toString()
                    var lastName = data.child("lastName").value.toString()
                    var mobile = data.child("mobile").value.toString()
                    var email = data.child("email").value.toString()
                    var facebookUrl = data.child("facebookURL").value.toString()
                    var school = data.child("school").value.toString()
                    var batch = data.child("batch").value.toString()
                    var section = data.child("section").value.toString()

                    var student = Students(
                        userID,
                        imageProfile,
                        imageOld,
                        firstName,
                        middleName,
                        lastName,
                        maidenName,
                        mobile,
                        email,
                        facebookUrl,
                        school,
                        batch,
                        section)

                    students.add(student)

                }

                val adapter = StudentAdapter(students)
                adapter.onItemClick ={
                    val intent = Intent(applicationContext, StudentDetailActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(applicationContext, it.firstName, Toast.LENGTH_SHORT).show()
                }

                binding.myRecycler.adapter = adapter
                binding.myRecycler.layoutManager = LinearLayoutManager(applicationContext)
//                binding.myRecycler.layoutManager = GridLayoutManager(this@MySectionActivity, 2)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        )
//    }private fun updateData(name : String, salary : String, id : String) {
//        var mapData = mutableMapOf<String,String>()
//        mapData["name"] = name
//        mapData["salary"] = salary
//        dao.update(id,mapData)
    }
}