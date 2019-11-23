package com.good.solscript.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.good.solscript.R
import com.good.solscript.data.CategoryData
import com.good.solscript.data.ResponseCategorySubData
import com.good.solscript.databinding.RecyclerCategoryItemBinding
import com.good.solscript.databinding.RecyclerSelectedItemBinding

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(val binding: RecyclerCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var data = listOf<ResponseCategorySubData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_category_item, parent, false)
        return CategoryViewHolder(RecyclerCategoryItemBinding.bind(view))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.binding.categoryData = data[position]
    }

}