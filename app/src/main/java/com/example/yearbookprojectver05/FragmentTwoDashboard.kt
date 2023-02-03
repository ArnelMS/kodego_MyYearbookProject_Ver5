package com.example.yearbookprojectver05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yearbookprojectver05.databinding.FragmentTwoDashboardBinding
import com.google.android.material.tabs.TabLayout

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
                DataClassDashboardPosts(R.drawable.dashboar_icon, "waiting", "Waiting"),
                DataClassDashboardPosts(R.drawable.add_photo, "waiting", "Waiting"),
                DataClassDashboardPosts(R.drawable.dashboar_icon, "waiting", "Waiting"),
                DataClassDashboardPosts(R.drawable.add_photo, "waiting", "Waiting"),
                DataClassDashboardPosts(R.drawable.dashboar_icon, "waiting", "Waiting"),
                DataClassDashboardPosts(R.drawable.add_photo, "waiting", "Waiting"),
                DataClassDashboardPosts(R.drawable.dashboar_icon, "waiting", "Waiting"),
                DataClassDashboardPosts(R.drawable.add_photo, "waiting", "Waiting"),
                DataClassDashboardPosts(R.drawable.dashboar_icon, "waiting", "Waiting"),
                DataClassDashboardPosts(R.drawable.add_photo, "waiting", "Waiting"),
                DataClassDashboardPosts(R.drawable.dashboar_icon, "waiting", "Waiting"),
                DataClassDashboardPosts(R.drawable.add_photo, "waiting", "Waiting")
            )
            val adapter = DashboardAdapter(dashboardList)

            binding.recyclerDashboard.adapter = adapter
            binding.recyclerDashboard.layoutManager = LinearLayoutManager(activity)

            return binding.root
        }
    }
}

//applicationContext() sa Fragment requiredContext()