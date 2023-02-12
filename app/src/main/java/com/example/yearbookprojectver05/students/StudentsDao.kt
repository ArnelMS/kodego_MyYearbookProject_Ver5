package com.example.yearbookprojectver05.students

import android.content.Intent
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.Objects

class StudentsDao {
    private var dbReference : DatabaseReference = Firebase.database.reference

    fun add(students: Students){
        dbReference.push().setValue(students)
//        dbReference.child("StudentRecords").push().setValue(students)
    }

    fun get():Query {
        return dbReference.orderByKey()
//        return dbReference.child("StudentRecords").orderByKey()

    }
    fun remove(key:String){
        dbReference.child(key).removeValue()
    }

    fun update(key:String, map: Map<String,String>){
        dbReference.child(key).updateChildren(map)
    }


}