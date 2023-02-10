package com.example.yearbookprojectver05.dashboard

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yearbookprojectver05.R
import com.example.yearbookprojectver05.databinding.RowItemDashboardBinding
import com.google.firebase.storage.FirebaseStorage
import java.io.File


class DashboardAdapter(val dashboardModel:MutableList<Dashboard>):RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {

    inner class DashboardViewHolder( val binding: RowItemDashboardBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowItemDashboardBinding.inflate(layoutInflater, parent, false)
        return DashboardViewHolder(binding)
    }
    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.binding.apply {

            if(dashboardModel[position].imageDashboardItem == "") {
                imgDashboardNewItem.setImageResource(R.drawable.profile_modern)
            } else {
                // Retrieve Image
                val imageName = dashboardModel[position].imageDashboardItem
                val storageRef = FirebaseStorage.getInstance().reference.child("images/$imageName")
                val localFile = File.createTempFile("tempImage","jpg")
                storageRef.getFile(localFile)
                    .addOnSuccessListener {
                        val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                        imgDashboardNewItem.setImageBitmap(bitmap)
                    }
            }

            etItemTitle.text = dashboardModel[position].itemDashTitle
            etItemDescription.text = dashboardModel[position].itemDashTitle

            return
        }
    }

    override fun getItemCount(): Int {
        return dashboardModel.size
    }




}