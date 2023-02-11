package com.example.yearbookprojectver05.Fragment02_Dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yearbookprojectver05.dashboard.Dashboard
import com.example.yearbookprojectver05.dashboard.DashboardDao
import com.example.yearbookprojectver05.databinding.FragmentTwoDashboardBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class FragmentTwoDashboard : Fragment(){

    lateinit var binding: FragmentTwoDashboardBinding
    var dao = DashboardDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentTwoDashboardBinding.inflate(layoutInflater)
        binding.root

//        var adapter = DashboardAdapter(dashboard)
        binding.recyclerViewDashboard.adapter
        binding.recyclerViewDashboard.layoutManager = LinearLayoutManager(activity)


        view()

//            binding.btnAddItemDashboard.setOnClickListener() {
//                val itemTitle = binding.etItemTitle.toString()
//                val itemDashDescription = binding.etItemDescription.text.toString()
//                val imageDashboardItem = binding.imgDashboardNewItem.toString()
//
//                dao.add(
//                    Dashboard(
//                        itemTitle,
//                        itemDashDescription,
//                        imageDashboardItem
//                    )
//                )
//                val intent = Intent(context, FragmentTwoDashboardBinding::class.java)
//                startActivity(intent)
    }

    private fun view() {
        dao.get().addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var dashboards: ArrayList<Dashboard> = ArrayList<Dashboard>()

                var dataFromDb = snapshot.children
//                Toast.makeText(applicationContext, ""+dataFromDb, Toast.LENGTH_SHORT).show()

                for (data in dataFromDb) {
                    var id = data.key.toString()
                    var imageDashboardMain = data.child("imageDashboardItem").value.toString()
                    var itemTitle = data.child("itemDashTitle").value.toString()
                    var itemDescription = data.child("itemDashDescription").value.toString()

                    var dashboard = Dashboard(
                        imageDashboardMain,
                        itemTitle,
                        itemDescription
                    )

                    dashboards.add(dashboard)

                }
            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        )

    }
}











//
//        override fun onCreateView(
//            inflater: LayoutInflater, container: ViewGroup?,
//            savedInstanceState: Bundle?
//        ): View? {
//            var binding = FragmentTwoDashboardBinding.inflate(layoutInflater)
//
//
//            //data source
//            val dashboardList = mutableListOf<DataClassDashboardPosts>(
//                DataClassDashboardPosts("Image", "Item Title", "Item Description"),
//                DataClassDashboardPosts("Image", "Item Title", "Item Description"),
//                DataClassDashboardPosts("Image", "Item Title", "Item Description"),
//                DataClassDashboardPosts("Image", "Item Title", "Item Description"),
//                DataClassDashboardPosts("Image", "Item Title", "Item Description"),
//                DataClassDashboardPosts("Image", "Item Title", "Item Description")
//            )
//            val adapter = DashboardAdapter(dashboardList)
//
//            binding.recyclerViewDashboard.adapter = adapter
//            binding.recyclerViewDashboard.layoutManager = LinearLayoutManager(activity)
//
//            return binding.root
//        }
//    }
//}