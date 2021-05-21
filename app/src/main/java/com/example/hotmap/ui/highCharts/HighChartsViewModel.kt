package com.example.hotmap.ui.highCharts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HighChartsViewModel : ViewModel() {
    val chartUrl = "file:///android_asset/highCharts/highCharts.html"

    val runJsCode by lazy {
        MutableLiveData("")
    }

    fun createChart() {
        runJsCode.value = "javascript:createChart()"
    }
}