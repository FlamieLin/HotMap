package com.example.hotmap.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotmap.adapter.PageListAdapter
import com.example.hotmap.adapter.PageListItemViewModel
import com.example.hotmap.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return MainFragmentBinding.inflate(inflater, container, false).also { binding ->
            binding.viewModel = viewModel
            binding.lifecycleOwner = viewLifecycleOwner

            binding.pageListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.pageListRecyclerView.adapter = PageListAdapter(viewLifecycleOwner).apply {
                submitList(MutableList(viewModel.pageList.size) {
                    viewModel.getItem(it)
                })
            }
        }.root
    }
}