package com.example.yearbookprojectver05.dashboard

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Query
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DashboardDao {
    var dbReference: DatabaseReference = Firebase.database.reference

    fun add(dashboard: Dashboard) {
        dbReference.child("Dashboard").push().setValue(dashboard)
    }

    fun get(): Query {
        return dbReference.orderByKey()

    }

    fun remove(key: String) {
        dbReference.child(key).removeValue()
    }

    fun update(key: String, map: Map<String, String>) {
        dbReference.child(key).updateChildren(map)
    }
}