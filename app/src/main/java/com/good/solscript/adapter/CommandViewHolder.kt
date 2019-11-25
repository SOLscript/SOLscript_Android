package com.good.solscript.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.good.solscript.data.ResponseRecommandSubData
import kotlinx.android.synthetic.main.recyclerview_recommand_item.view.*

class CommandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvTitle = itemView.tv_recommand_title
    private val tvSubTitle = itemView.tv_recommand_subtitle
    val ivSubnail = itemView.iv_recommand

    fun bind(recommandData: ResponseRecommandSubData) {
        tvTitle.text = recommandData.title
        tvSubTitle.text = recommandData.subTitle
    }
}