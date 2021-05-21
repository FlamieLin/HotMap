package com.example.hotmap.adapter

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.hotmap.ui.main.MainFragmentDirections

class PageListItemViewModel(val title: String, private val onClick: (View) -> Unit) : ViewModel() {

    fun onItemClick(view: View) {
        onClick(view)
    }
}