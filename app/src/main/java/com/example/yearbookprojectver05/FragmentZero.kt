package com.example.yearbookprojectver05

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yearbookprojectver05.databinding.FragmentZeroBinding

class FragmentZeroAppCompat : AppCompatActivity(){
}
class FragmentZero : Fragment() {

    lateinit var binding: FragmentZeroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):
            View? {
        binding = FragmentZeroBinding.inflate(layoutInflater)
        val studentList = mutableListOf<Students>(
        Students(R.drawable.dashboar_icon, R.drawable.dashboar_icon, "Mendoza", "Sebastian", "n/a", "n/a",123456,"user1@email.com","www.facebook.com/arenelmsebastian"),
        Students(R.drawable.profile_photo3, R.drawable.dashboar_icon, "Mendoza", "Sebastian", "n/a", "n/a",639998846513,"user1@email.com","www.facebook.com/arenelmsebastian"),
        Students(R.drawable.coloredboxes, R.drawable.dashboar_icon, "Mendoza", "Sebastian", "n/a", "n/a",+639998846513,"user1@email.com","www.facebook.com/arenelmsebastian"),
        Students(R.drawable.section_png72, R.drawable.dashboar_icon, "Mendoza", "Sebastian", "n/a", "n/a",+639998846513,"user1@email.com","www.facebook.com/arenelmsebastian")
        )

        val adapter = StudentsAdapter(studentList)
        adapter.onItemClick = {
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

        }

        binding.studentsRecyclerView.adapter = adapter
//        binding.studentsRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        binding.studentsRecyclerView.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }
}


//        var textFromParent = arguments?.getString("data1")
//        binding.tvSampleClick.text = textFromParent
//        binding.tvSampleClick.setOnClickListener(){
