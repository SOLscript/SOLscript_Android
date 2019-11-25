package com.good.solscript.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.good.solscript.R
import com.good.solscript.data.ResponseRecommandSubData
import kotlinx.android.synthetic.main.recyclerview_recommand_item.view.*

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
        Glide.with(holder.itemView.context)
            .load(recommandList[position].image)
            .into(holder.ivSubnail)

    }

    fun setData(setList: List<ResponseRecommandSubData>) {
        this.recommandList.clear()
        this.recommandList.addAll(setList)
        notifyDataSetChanged()

    }
}