package com.example.yearbookprojectver05

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Query
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class StudentsDao {
    var dbReference : DatabaseReference = Firebase.database.reference

    fun add(students: Students){
        dbReference.push().setValue(students)
    }

    fun get():Query {
        return dbReference.orderByKey()

    }
}