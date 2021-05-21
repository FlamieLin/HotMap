package com.example.hotmap.ui.eCharts

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.hotmap.databinding.EChartsFragmentBinding

class EChartsFragment : Fragment() {

    companion object {
        fun newInstance() = EChartsFragment()
    }

    private val viewModel: EChartsViewModel by viewModels()
    private lateinit var binding: EChartsFragmentBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return EChartsFragmentBinding.inflate(inflater, container, false).also { binding ->
            this.binding = binding
            binding.viewModel = viewModel
            binding.lifecycleOwner = viewLifecycleOwner

            binding.eChartsWebView.apply {
                settings.javaScriptEnabled = true
                loadUrl(viewModel.chartUrl)
                webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        viewModel.createChart()
                    }
                }
            }
        }.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {

                viewModel.runJsCode.observe(owner) {
                    if (!it.isNullOrEmpty()) {
                        viewModel.runJsCode.value = ""
                        binding.eChartsWebView.evaluateJavascript(it, null)
                    }
                }

                owner.lifecycle.removeObserver(this)
            }
        })
    }
}