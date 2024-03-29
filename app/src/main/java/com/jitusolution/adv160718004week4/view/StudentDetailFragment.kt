package com.jitusolution.adv160718004week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jitusolution.adv160718004week4.R
import com.jitusolution.adv160718004week4.databinding.FragmentStudentDetailBinding
import com.jitusolution.adv160718004week4.model.Student
import com.jitusolution.adv160718004week4.util.loadImage
import com.jitusolution.adv160718004week4.viewmodel.DetailViewModel
import com.jitusolution.adv160718004week4.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentDetailFragment : Fragment(), ButtonSaveChangesClickListener {
    private lateinit var viewModel:DetailViewModel
    private val studentListAdapter = StudentListAdapter(arrayListOf())
    private lateinit var dataBinding:FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail,container,false)
        return dataBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(id)

        observeViewModel()
    }

    fun  observeViewModel() {
        //param 1 siapa yang observe,harusnya this. tapi ada update dari anstud jadi g bisa this
        //tapi pakai viewlifecycleowner
        //Observer itu interface yagng bisa langsung dibuat anonymous bentuknya lambda,it nya list of students
//        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
//            txtId.setText(it.id)
//            txtName.setText(it.name)
//            txtBod.setText(it.bod)
//            txtPhone.setText(it.phone)
//            imageView2.loadImage(it.photoUrl.toString(), progressBar2)
//
//        })
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
        })
    }

    override fun onButtonSaveChangesClick(v: View, obj: Student) {
        Toast.makeText(v.context, "Student Updated", Toast.LENGTH_SHORT).show()
    }
}