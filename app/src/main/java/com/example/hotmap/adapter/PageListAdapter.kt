package com.example.hotmap.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hotmap.databinding.PageListItemLayoutBinding

class PageListAdapter(private val lifecycleOwner: LifecycleOwner) :
    ListAdapter<PageListItemViewModel, PageListAdapter.PageListItemViewHolder>(object :
        DiffUtil.ItemCallback<PageListItemViewModel>() {
        override fun areItemsTheSame(
            oldItem: PageListItemViewModel,
            newItem: PageListItemViewModel
        ): Boolean {
            return true
        }

        override fun areContentsTheSame(
            oldItem: PageListItemViewModel,
            newItem: PageListItemViewModel
        ): Boolean {
            return newItem.title == oldItem.title
        }

    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageListItemViewHolder {

        return PageListItemViewHolder(
            PageListItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), lifecycleOwner
        )
    }

    override fun onBindViewHolder(holder: PageListItemViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class PageListItemViewHolder(
        private val binding: PageListItemLayoutBinding,
        private val lifecycleOwner: LifecycleOwner
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(viewModel: PageListItemViewModel) {
            binding.viewModel = viewModel
            binding.lifecycleOwner = lifecycleOwner
            binding.executePendingBindings()
        }
    }
}