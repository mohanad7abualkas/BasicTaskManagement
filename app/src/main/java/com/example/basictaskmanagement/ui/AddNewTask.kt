package com.example.basictaskmanagement.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.basictaskmanagement.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.basictaskmanagement.databinding.ActivityAddNewTaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddNewTask : BottomSheetDialogFragment() {

    //private lateinit var binding: ActivityMainBinding
    private lateinit var binding: ActivityAddNewTaskBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity()
        taskViewModel = ViewModelProvider(activity)[TaskViewModel::class.java]   // like get() 'same thing'
        binding.btnSave.setOnClickListener {
            saveAction()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // binding = ActivityMainBinding.inflate(inflater, container, false)
        binding = ActivityAddNewTaskBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun saveAction(){
        taskViewModel.name.value = binding.tvName.text.toString()
        taskViewModel.desc.value = binding.tvDesc.text.toString()
        binding.tvName.setText("")
        binding.tvDesc.setText("")
        dismiss()
    }
}


