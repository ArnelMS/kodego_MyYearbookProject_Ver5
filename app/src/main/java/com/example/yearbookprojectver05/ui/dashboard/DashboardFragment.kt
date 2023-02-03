package com.example.yearbookprojectver05.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yearbookprojectver05.DashboardAdapter
import com.example.yearbookprojectver05.DataClassDashboardPosts
import com.example.yearbookprojectver05.R
import com.example.yearbookprojectver05.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


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

//        return binding.root


//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}