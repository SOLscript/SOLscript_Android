package com.good.solscript.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.good.solscript.R
import com.good.solscript.data.ResponseRecommandSubData

class RecommandAdapter : RecyclerView.Adapter<CommandViewHolder>() {

    private val recommandList = mutableListOf<ResponseRecommandSubData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommandViewHolder =
        CommandViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recyclerview_recommand_item,
                parent,
                false
            )
        )


    override fun getItemCount(): Int = recommandList.size

    override fun onBindViewHolder(holder: CommandViewHolder, position: Int) {
        holder.bind(recommandList[position])
    }

    fun setData(setList: List<ResponseRecommandSubData>) {
        this.recommandList.clear()
        this.recommandList.addAll(setList)
        notifyDataSetChanged()

    }
}