package com.example.yearbookprojectver05.Fragment02_Dashboard

import android.app.ProgressDialog
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yearbookprojectver05.dashboard.Dashboard
import com.example.yearbookprojectver05.dashboard.DashboardAdapter
import com.example.yearbookprojectver05.dashboard.DataClassDashboardPosts
import com.example.yearbookprojectver05.databinding.FragmentTwoDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FragmentTwoAppCompat : AppCompatActivity() {
    class FragmentTwoDashboard : Fragment() {

        lateinit var binding: FragmentTwoDashboardBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = FragmentTwoDashboardBinding.inflate(layoutInflater)
            binding.root
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            var binding = FragmentTwoDashboardBinding.inflate(layoutInflater)


            //data source
            val dashboardList = mutableListOf<DataClassDashboardPosts>(
                DataClassDashboardPosts("Image", "Item Title", "Item Description"),
                DataClassDashboardPosts("Image", "Item Title", "Item Description"),
                DataClassDashboardPosts("Image", "Item Title", "Item Description"),
                DataClassDashboardPosts("Image", "Item Title", "Item Description"),
                DataClassDashboardPosts("Image", "Item Title", "Item Description"),
                DataClassDashboardPosts("Image", "Item Title", "Item Description")
            )
            val adapter = DashboardAdapter(dashboardList)

            binding.RecyvlerViewDashboard.adapter = adapter
            binding.RecyvlerViewDashboard.layoutManager = LinearLayoutManager(activity)

            return binding.root
        }
    }
}