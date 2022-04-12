package com.valentine.networkingsample.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.valentine.networkingsample.R
import com.valentine.networkingsample.databinding.ItemCarBinding
import com.valentine.networkingsample.model.GetAllCarResponseItem
import java.text.NumberFormat
import java.util.*

class CarAdapter : ListAdapter<GetAllCarResponseItem, CarAdapter.ViewHolder>(CarDiffCallBack()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemCarBinding.bind(view)

        fun bind(data: GetAllCarResponseItem) {
            val dec = NumberFormat.getNumberInstance(Locale.US)
            val price = dec.format(data.price)
            binding.apply {
                txtName.text = data.name
                txtCategory.text = itemView.context.getString(R.string.category, data.category)
                txtPrice.text = itemView.context.getString(R.string.price, price)
                Glide.with(binding.root).load(data.image).into(binding.imgCar)
                root.setOnClickListener {
                    val dataDetail = HomeFragmentDirections.actionHomeFragmentToDetailFragment(data)
                    it.findNavController().navigate(dataDetail)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }
}

class CarDiffCallBack : DiffUtil.ItemCallback<GetAllCarResponseItem>() {
    override fun areItemsTheSame(oldItem: GetAllCarResponseItem, newItem: GetAllCarResponseItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GetAllCarResponseItem, newItem: GetAllCarResponseItem): Boolean {
        return oldItem == newItem
    }
}