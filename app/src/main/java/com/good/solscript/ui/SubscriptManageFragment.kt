package com.good.solscript.ui


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.good.solscript.R
import com.good.solscript.adapter.ManageAdapter
import com.good.solscript.data.ManageData
import com.good.solscript.util.CustomTemplate
import kotlinx.android.synthetic.main.fragment_subscript_manage.*

/**
 * A simple [Fragment] subclass.
 */
class SubscriptManageFragment : Fragment() {

    private val manageAdapter by lazy { ManageAdapter() }


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_subscript_manage, container, false)
    }

    override fun onViewCreated(rootView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(rootView, savedInstanceState)

        setManagerRecyclerView()
        setBarChart()
    }

    fun setBarChart(){

        var barEntry = ArrayList<BarEntry>()
        var barEntryLabel = ArrayList<String>()

        barEntry.add(BarEntry(1f,60f))
        barEntry.add(BarEntry(2f,90f))
        barEntry.add(BarEntry(3f,30f))
        barEntry.add(BarEntry(4f,70f))
        barEntry.add(BarEntry(5f,20f))
        barEntry.add(BarEntry(6f,20f))

        barEntryLabel.add("6월")
        barEntryLabel.add("7월")
        barEntryLabel.add("8월")
        barEntryLabel.add("9월")
        barEntryLabel.add("10월")
        barEntryLabel.add("11월")

        val barDataSet = BarDataSet(barEntry,"project")
        barDataSet.setColors(*CustomTemplate.SHINHAN_COLORS_0)

        val barData = BarData(barDataSet)
        barData.barWidth = 0.4f
        val description = Description()
        description.text = ""

        bc_managefrag_usagechart.description = description


        var yLAxis = bc_managefrag_usagechart.axisLeft
        yLAxis.setDrawLabels(false)
        yLAxis.setDrawAxisLine(false)
        yLAxis.setDrawGridLines(false)

        var yRAxis = bc_managefrag_usagechart.axisRight
        yRAxis.setDrawLabels(false)
        yRAxis.setDrawAxisLine(false)
        yRAxis.setDrawGridLines(false)

        bc_managefrag_usagechart.xAxis.textColor = Color.WHITE
        bc_managefrag_usagechart.xAxis.position = XAxis.XAxisPosition.BOTTOM

        bc_managefrag_usagechart.xAxis.setDrawGridLines(false)

        bc_managefrag_usagechart.data = barData
        bc_managefrag_usagechart.animateY(2000)
    }

    fun setManagerRecyclerView(){
        val dataList = arrayListOf<ManageData>()

        dataList.add(ManageData("Netflix","0","https://images-na.ssl-images-amazon.com/images/I/41Ix1vMUK7L._SY355_.png",9500, "매 달 갱신", false, 10))
        dataList.add(ManageData("Netflix","0","https://images-na.ssl-images-amazon.com/images/I/41Ix1vMUK7L._SY355_.png",9500, "매 달 갱신", true, 30))
        dataList.add(ManageData("Netflix","0","https://images-na.ssl-images-amazon.com/images/I/41Ix1vMUK7L._SY355_.png",9500, "매 달 갱신", true, 30))
        dataList.add(ManageData("Netflix","0","https://images-na.ssl-images-amazon.com/images/I/41Ix1vMUK7L._SY355_.png",9500, "매 달 갱신", false, 90))
        manageAdapter.data = dataList
        manageAdapter.notifyDataSetChanged()

        rv_managefrag_analysislist.apply {
            layoutManager = LinearLayoutManager(activity?.applicationContext)
            adapter = manageAdapter
        }

    }


}