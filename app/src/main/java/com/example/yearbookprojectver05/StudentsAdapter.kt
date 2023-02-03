package com.example.yearbookprojectver05

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yearbookprojectver05.databinding.RowItemStudentsBinding

class StudentsAdapter(val students: List<Students>):RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder>(){

    var onItemClick : ((Students) -> Unit)? = null
    inner class StudentsViewHolder (val binding: RowItemStudentsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowItemStudentsBinding.inflate(layoutInflater, parent, false)

        return StudentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        holder.binding.apply {
            imgProfileNew.setImageResource(students[position].imageNew)
            imgProfileOld.setImageResource(students[position].imageOld)
            tvFirstName2.text=students[position].firstName
            tvMiddleName2.text=students[position].middleName
            tvLastName2.text=students[position].lastName
            tvMaidenName2.text=students[position].maidenName
            tvMobile2.text=students[position].mobile.toLong().toString()
            tvEmail2.text=students[position].email
            tvFacebookURL2.text=students[position].facebookURL
        }


        holder.itemView.setOnClickListener(){
            onItemClick?.invoke(students[position])

        }
    }

    override fun getItemCount(): Int {
        return students.size
    }


}