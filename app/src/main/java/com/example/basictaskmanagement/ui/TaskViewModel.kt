package com.example.basictaskmanagement.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    val desc = MutableLiveData<String>()
}




















