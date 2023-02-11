package com.example.yearbookprojectver05.students

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yearbookprojectver05.R
import com.example.yearbookprojectver05.databinding.RowItemStudentsBinding
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class StudentAdapter(val students: MutableList<Students>):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    inner class StudentViewHolder(var binding: RowItemStudentsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowItemStudentsBinding.inflate(layoutInflater,parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.apply {

            tvFirstName2.text = students[position].firstName
            tvFirstName2.text = students[position].firstName
            tvMiddleName2.text = students[position].middleName
            tvLastName2.text = students[position].lastName
            tvMaidenName2.text = students[position].maidenName
            tvMobile2.text = students[position].mobile
            tvEmail2.text = students[position].email
            tvFacebookURL2.text = students[position].facebookURL
//            tvSchool2.text = students[position].middleName
//            tvBatch2.text = students[position].lastName
//            tvSection2.text = students[position].maidenName

            if(students[position].imageNew == "") {
                imgProfileNew.setImageResource(R.drawable.profile_modern)
            } else {
                // Retrieve Image
                val imageName = students[position].imageNew
                val storageRef = FirebaseStorage.getInstance().reference.child("images/$imageName")
                val localFile = File.createTempFile("tempImage","jpg")
                storageRef.getFile(localFile)
                    .addOnSuccessListener {
                        val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                        imgProfileNew.setImageBitmap(bitmap)
                    }
            }

            if(students[position].imageOld == "") {
                imgGradPic.setImageResource(R.drawable.profile_gradpic)
            } else {
                // Retrieve Image
                val imageName = students[position].imageOld
                val storageRef = FirebaseStorage.getInstance().reference.child("images/$imageName")
                val localFile = File.createTempFile("tempImage","jpg")
                storageRef.getFile(localFile)
                    .addOnSuccessListener {
                        val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                        imgGradPic.setImageBitmap(bitmap)
                    }
            }



            return

//            btnDelete.setOnClickListener() {
//                onItemDelete?.invoke(employeeModel[position],position)
//            }
//            btnEdit.setOnClickListener() {
//                onUpdate?.invoke(employeeModel[position],position)
//            }
        }

    }
    override fun getItemCount(): Int {
        return students.size
    }

}