package com.good.solscript.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.good.solscript.R
import com.good.solscript.data.SubscriptData
import com.good.solscript.databinding.RecyclerSubscriptItemBinding

class SubscriptListAdapter : RecyclerView.Adapter<SubscriptListAdapter.SubscriptViewHolder>() {

    class SubscriptViewHolder(val binding : RecyclerSubscriptItemBinding) : RecyclerView.ViewHolder(binding.root)

    var data = listOf<SubscriptData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriptViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_subscript_item,parent,false)

        val viewHolder = SubscriptViewHolder(RecyclerSubscriptItemBinding.bind(view))

        return viewHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SubscriptViewHolder, position: Int) {
        holder.binding.subscriptData = data[position]
    }

}