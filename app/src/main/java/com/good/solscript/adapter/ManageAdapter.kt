package com.good.solscript.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.good.solscript.R
import com.good.solscript.data.ManageData
import com.good.solscript.data.SelectedData
import com.good.solscript.databinding.RecyclerManageItemBinding
import com.good.solscript.databinding.RecyclerSelectedItemBinding

class ManageAdapter : RecyclerView.Adapter<ManageAdapter.ManageViewHolder>() {

    class ManageViewHolder(val binding: RecyclerManageItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var data = listOf<ManageData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_manage_item, parent, false)
        return ManageViewHolder(RecyclerManageItemBinding.bind(view))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ManageViewHolder, position: Int) {
        holder.binding.manageData = data[position]
    }

}