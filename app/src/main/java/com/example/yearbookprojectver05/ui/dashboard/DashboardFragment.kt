package com.example.yearbookprojectver05.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yearbookprojectver05.dashboard.DashboardAdapter
import com.example.yearbookprojectver05.dashboard.DataClassDashboardPosts
import com.example.yearbookprojectver05.R
import com.example.yearbookprojectver05.databinding.FragmentDashboardBinding
import com.example.yearbookprojectver05.databinding.FragmentTwoDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

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
//            val dashboardList = mutableListOf<DataClassDashboardPosts>(
//                DataClassDashboardPosts(R.drawable.dashboar_icon, "waiting", "Waiting"),
//                DataClassDashboardPosts(R.drawable.add_photo, "waiting", "Waiting"),
//                DataClassDashboardPosts(R.drawable.dashboar_icon, "waiting", "Waiting"),
//                DataClassDashboardPosts(R.drawable.add_photo, "waiting", "Waiting"),
//                DataClassDashboardPosts(R.drawable.dashboar_icon, "waiting", "Waiting"),
//                DataClassDashboardPosts(R.drawable.add_photo, "waiting", "Waiting"),
//                DataClassDashboardPosts(R.drawable.dashboar_icon, "waiting", "Waiting"),
//                DataClassDashboardPosts(R.drawable.add_photo, "waiting", "Waiting"),
//                DataClassDashboardPosts(R.drawable.dashboar_icon, "waiting", "Waiting"),
//                DataClassDashboardPosts(R.drawable.add_photo, "waiting", "Waiting"),
//                DataClassDashboardPosts(R.drawable.dashboar_icon, "waiting", "Waiting"),
//                DataClassDashboardPosts(R.drawable.add_photo, "waiting", "Waiting")
//            )
//            val adapter = DashboardAdapter(dashboardList)
//
//            binding.RecyvlerViewDashboard.adapter = adapter
//            binding.RecyvlerViewDashboard.layoutManager = LinearLayoutManager(activity)

            return binding.root
        }
    }
}

//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
//        return root
//    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }