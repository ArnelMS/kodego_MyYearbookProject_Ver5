package com.example.yearbookprojectver05.students

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yearbookprojectver05.R
import com.example.yearbookprojectver05.databinding.RowItemStudentsBinding
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class StudentAdapter(val studentModel: MutableList<Students>):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    inner class StudentViewHolder(var binding: RowItemStudentsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowItemStudentsBinding.inflate(layoutInflater,parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.apply {

            if(studentModel[position].imageNew == "") {
                imgProfileNew.setImageResource(R.drawable.profile_modern)
            } else {
                // Retrieve Image
                val imageName = studentModel[position].imageNew
                val storageRef = FirebaseStorage.getInstance().reference.child("images/$imageName")
                val localFile = File.createTempFile("tempImage","jpg")
                storageRef.getFile(localFile)
                    .addOnSuccessListener {
                        val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                        imgProfileNew.setImageBitmap(bitmap)
                    }
            }

            if(studentModel[position].imageOld == "") {
                imgGradPic.setImageResource(R.drawable.profile_gradpic)
            } else {
                // Retrieve Image
                val imageName = studentModel[position].imageOld
                val storageRef = FirebaseStorage.getInstance().reference.child("images/$imageName")
                val localFile = File.createTempFile("tempImage","jpg")
                storageRef.getFile(localFile)
                    .addOnSuccessListener {
                        val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                        imgGradPic.setImageBitmap(bitmap)
                    }
            }

            tvFirstName2.text = studentModel[position].firstName
            tvFirstName2.text = studentModel[position].firstName
            tvMiddleName2.text = studentModel[position].middleName
            tvLastName2.text = studentModel[position].lastName
            tvMaidenName2.text = studentModel[position].maidenName
//            tvMobile.text = studentModel[position].mobile
            tvEmail2.text = studentModel[position].email
            tvFacebookURL2.text = studentModel[position].facebookURL
//            tvSchool2.text = studentModel[position].middleName
//            tvBatch2.text = studentModel[position].lastName
//            tvSection2.text = studentModel[position].maidenName

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
        return studentModel.size
    }

}