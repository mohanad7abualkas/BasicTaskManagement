package com.example.basictaskmanagement.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.ViewModelProvider
import com.example.basictaskmanagement.R
import com.example.basictaskmanagement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        taskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]   // like get() 'same thing'
        binding.ibtnAdd.setOnClickListener {
            AddNewTask().show(supportFragmentManager, "${R.layout.activity_add_new_task}")
        }

        taskViewModel.name.observe(this){
            binding.tvTaskTitle.text = String.format("Task Name: %s", it)
        }

        taskViewModel.desc.observe(this){
            binding.tvTaskDes.text = String.format("Task Description: %s", it)
        }
    }
}






































