package com.good.solscript.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.good.solscript.R
import com.good.solscript.data.AnalysisData
import com.good.solscript.databinding.RecyclerAnaysisItemBinding

class AnalysisAdapter : RecyclerView.Adapter<AnalysisAdapter.SelectedViewHolder>() {

    class SelectedViewHolder(val binding: RecyclerAnaysisItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var data = listOf<AnalysisData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_anaysis_item, parent, false)
        return SelectedViewHolder(RecyclerAnaysisItemBinding.bind(view))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SelectedViewHolder, position: Int) {
        holder.binding.analysisData = data[position]
    }

}