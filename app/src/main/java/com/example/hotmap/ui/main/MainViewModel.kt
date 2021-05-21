package com.example.hotmap.ui.main

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.hotmap.adapter.PageListItemViewModel

class MainViewModel : ViewModel() {

    val pageList = mutableListOf(
        "EChart",
        "HighCharts"
    )

    fun getItem(position: Int): PageListItemViewModel {
        return pageList[position].let { name ->
            val onClick: (View) -> Unit = when (name) {
                "EChart" -> fun(view: View) {
                    MainFragmentDirections.actionMainFragmentToECharts().apply {
                        view.findNavController().navigate(this)
                    }
                }
                "HighCharts" -> fun(view: View) {
                    MainFragmentDirections.actionMainFragmentToHighChartsFragment().apply {
                        view.findNavController().navigate(this)
                    }
                }
                else -> fun(_: View) {

                }
            }

            PageListItemViewModel(pageList[position], onClick)
        }
    }
}