package com.example.test.viewmodel

import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val data = mutableListOf("item1", "item2")
    fun loadData() {
        // Load data and update _data
    }
}