package com.example.yearbookprojectver05.Fragment02_Dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yearbookprojectver05.dashboard.Dashboard
import com.example.yearbookprojectver05.dashboard.DashboardAdapter
import com.example.yearbookprojectver05.dashboard.DashboardDao
import com.example.yearbookprojectver05.databinding.FragmentTwoDashboardBinding
import com.google.android.gms.maps.model.Dash
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class FragmentTwoDashboard : Fragment(){

    lateinit var binding: FragmentTwoDashboardBinding
    lateinit var adapter : DashboardAdapter
    private var dao = DashboardDao()

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        todoDB = TodoDatabase.invoke(context)
//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        view()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoDashboardBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun view() {
        dao.get().addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var dashboards: ArrayList<Dashboard> = ArrayList<Dashboard>()

                var dataFromDb = snapshot.children
                Toast.makeText(context, ""+dataFromDb, Toast.LENGTH_SHORT).show()

//                for (data in dataFromDb) {
//                    var idDash = data.key.toString()
//                    var imageDashboardMain = data.child("imageDashboardItem").value.toString()
//                    var itemTitle = data.child("itemDashTitle").value.toString()
//                    var itemDescription = data.child("itemDashDescription").value.toString()
//
//                    var dashboard = Dashboard(
//                        imageDashboardMain,
//                        itemTitle,
//                        itemDescription
//                    )
//
//                    dashboards.add(dashboard)
//
//                }
//                adapter = DashboardAdapter(dashboards)
//                binding.recyclerViewDashboard.adapter = adapter
//                binding.recyclerViewDashboard.layoutManager = LinearLayoutManager(context)

            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        )

    }
}



