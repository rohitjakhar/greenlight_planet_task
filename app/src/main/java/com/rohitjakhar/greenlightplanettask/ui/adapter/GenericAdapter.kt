package com.rohitjakhar.greenlightplanettask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rohitjakhar.greenlightplanettask.databinding.ItemTextLayoutBinding
import com.rohitjakhar.greenlightplanettask.domain.model.GenericModel

class GenericAdapter(private val onClick: (String) -> Unit) :
    ListAdapter<GenericModel, GenericAdapter.AreaAdapterVH>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaAdapterVH {
        return AreaAdapterVH(
            ItemTextLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AreaAdapterVH, position: Int) {
        holder.bind(getItem(position))
    }

    inner class AreaAdapterVH(private val binding: ItemTextLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: GenericModel) = binding.apply {
            tvName.text = data.name
            root.setOnClickListener {
                onClick.invoke(data.name)
            }
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<GenericModel>() {
            override fun areContentsTheSame(
                oldItem: GenericModel,
                newItem: GenericModel
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areItemsTheSame(oldItem: GenericModel, newItem: GenericModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}
