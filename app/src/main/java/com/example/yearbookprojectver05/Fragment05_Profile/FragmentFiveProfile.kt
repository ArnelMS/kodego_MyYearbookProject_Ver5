package com.example.yearbookprojectver05.Fragment05_Profile

import androidx.fragment.app.Fragment
import com.example.yearbookprojectver05.databinding.FragmentFiveProfileBinding
import com.example.yearbookprojectver05.students.StudentsDao

class FragmentFiveProfile : Fragment() {
    lateinit var binding: FragmentFiveProfileBinding
    var dao = StudentsDao()
    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentFiveProfileBinding.inflate(layoutInflater)

//
//        fun getProfile() {
//            dao.get().addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    var students: ArrayList<Students> = ArrayList<Students>()
//
//                    var dataFromDb = snapshot.children
////                Toast.makeText(applicationContext, ""+dataFromDb, Toast.LENGTH_SHORT).show()
//
//                    for (data in dataFromDb) {
//                        var id = data.key.toString()
//                        var imageProfile = data.child("imageNew").value.toString()
//                        var imageOld = data.child("imageOld").value.toString()
//                        var firstName = data.child("firstName").value.toString()
//                        var middleName = data.child("middleName").value.toString()
//                        var maidenName = data.child("maidenName").value.toString()
//                        var lastName = data.child("lastName").value.toString()
//                        var mobile = data.child("mobile").value.toString()
//                        var email = data.child("email").value.toString()
//                        var facebookUrl = data.child("facebookURL").value.toString()
//
//                        var student = Students(
//                            imageProfile,
//                            imageOld,
//                            firstName,
//                            middleName,
//                            lastName,
//                            maidenName,
//                            mobile,
//                            email,
//                            facebookUrl
//                        )
//                        dao.get()
//
//                    }
//
//                    val adapter = StudentAdapter(students)
//
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//
//                }
//            }
//        }
//    }
//}