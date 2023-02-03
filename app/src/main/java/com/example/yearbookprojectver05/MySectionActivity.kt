package com.example.yearbookprojectver05

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yearbookprojectver05.databinding.ActivityMySectionBinding
import com.example.yearbookprojectver05.databinding.FragmentZeroBinding

class MySectionActivity : AppCompatActivity() {

lateinit var binding: ActivityMySectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMySectionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val studentList = mutableListOf<Students>(
            Students(R.drawable.dashboar_icon, R.drawable.dashboar_icon, "Mendoza", "Sebastian", "n/a", "n/a",123456,"user1@email.com","www.facebook.com/arenelmsebastian"),
            Students(R.drawable.profile_photo3, R.drawable.dashboar_icon, "Mendoza", "Sebastian", "n/a", "n/a",639998846513,"user1@email.com","www.facebook.com/arenelmsebastian"),
            Students(R.drawable.coloredboxes, R.drawable.dashboar_icon, "Mendoza", "Sebastian", "n/a", "n/a",+639998846513,"user1@email.com","www.facebook.com/arenelmsebastian"),
            Students(R.drawable.section_png72, R.drawable.dashboar_icon, "Mendoza", "Sebastian", "n/a", "n/a",+639998846513,"user1@email.com","www.facebook.com/arenelmsebastian")
        )

        val adapter = StudentsAdapter(studentList)
        adapter.onItemClick = {
//            val intent : Intent()

            Toast.makeText(applicationContext, it.firstName, Toast.LENGTH_SHORT).show()
        }

        binding.studentsRecyclerView.adapter = adapter
//        binding.studentsRecyclerView.layoutManager = GridLayoutManager(this,2)
        binding.studentsRecyclerView.layoutManager = LinearLayoutManager(this)

//        return binding.root
    }
}

//            val intent = Intent(this, ActivityB::class.java)
//            startActivity(intent)

//            val intent :  Intent(this, StudentDetailActivity::class.java)
//            intent.putExtra("firstName".it.item)
//            intent.putExtra("middleName".it.item)
//            intent.putExtra("lastName".it.item)
//            intent.putExtra("maidenName".it.item)
//            intent.putExtra("firstName".it.item)
//            intent.putExtra("firstName".it.item)
//            intent.putExtra("firstName".it.item)

//            startActivity(intent)

//            Toast.makeText(applicationContext, it.itemName, Toast.LENGTH_SHORT ).show()
