package com.example.yearbookprojectver05

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yearbookprojectver05.databinding.RowItemDashboardBinding

class DashboardAdapter(val dashboardPosts:List<DataClassDashboardPosts>):RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {

    inner class DashboardViewHolder( val binding: RowItemDashboardBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowItemDashboardBinding.inflate(layoutInflater, parent, false)
        return DashboardViewHolder(binding)
    }
    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.binding.apply {
            imgDashboardPhoto.setImageResource(dashboardPosts[position].imageUpload)
            tvDashboardUsername.text = dashboardPosts[position].usernameDashboard
//            etDashboardPosts.text = dashboardPosts[position].postMessages


        }
    }

    override fun getItemCount(): Int {
    return dashboardPosts.size
    }




}