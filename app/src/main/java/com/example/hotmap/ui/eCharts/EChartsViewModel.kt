package com.example.hotmap.ui.eCharts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EChartsViewModel : ViewModel() {

    val chartUrl = "file:///android_asset/eCharts/eCharts.html"

    val runJsCode by lazy {
        MutableLiveData("")
    }

    fun createChart() {
        runJsCode.value = "javascript:createChart()"
    }
}