package com.good.solscript.ui

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.good.solscript.R
import com.good.solscript.adapter.AnalysisAdapter
import com.good.solscript.data.AnalysisData
import com.good.solscript.util.CustomTemplate
import kotlinx.android.synthetic.main.activity_analysis.*

class AnalysisActivity : AppCompatActivity() {



    private val analysisAdapter by lazy { AnalysisAdapter() }
    var data = ArrayList<AnalysisData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analysis)

        iv_analysisact_prev.setOnClickListener {
            Toast.makeText(applicationContext, "이전 달 통신", Toast.LENGTH_SHORT).show()
        }

        iv_analysisact_next.setOnClickListener {
            Toast.makeText(applicationContext, "다음 달 통산", Toast.LENGTH_SHORT).show()
        }

        setAnalysisRecyclerView()
    }

    fun setPieChart() {

        pc_analysisact_moneychart.setUsePercentValues(true)
        pc_analysisact_moneychart.setExtraOffsets(5F, 10F, 5F, 5F)

        pc_analysisact_moneychart.dragDecelerationFrictionCoef = 0.5f

//        pc_analysisact_moneychart.isDrawHoleEnabled = true

        pc_analysisact_moneychart.setHoleColor(Color.TRANSPARENT)
        pc_analysisact_moneychart.transparentCircleRadius = 44f
        pc_analysisact_moneychart.animateY(1800)

        val pieEntryList = ArrayList<PieEntry>()
        pieEntryList.add(PieEntry(data[0].percent, data[0].category))
        pieEntryList.add(PieEntry(data[1].percent, data[1].category))
        pieEntryList.add(PieEntry(data[2].percent, data[2].category))
        pieEntryList.add(PieEntry(data[3].percent, data[3].category))

        val dataSet = PieDataSet(pieEntryList, "사용량")
        dataSet.sliceSpace = 3f
        dataSet.selectionShift = 5f
        dataSet.setColors(*CustomTemplate.SHINHAN_COLORS)

        pc_analysisact_moneychart.setCenterTextColor(Color.WHITE)
        pc_analysisact_moneychart.centerText = "총\n22,300원"
        pc_analysisact_moneychart.setCenterTextSize(16f)

        val data = PieData(dataSet)
        data.setValueTextSize(10f)
        data.isHighlightEnabled = true
        data.setValueTextColor(Color.WHITE)
        pc_analysisact_moneychart.data = data
    }

    fun setAnalysisRecyclerView() {

        data.add(AnalysisData("식품", "13,600", 60.8f))
        data.add(AnalysisData("반려동물", "45,400", 20.3f))
        data.add(AnalysisData("미디어", "33,040", 14.9f))
        data.add(AnalysisData("생활용품", "14,000", 4.0f))

        analysisAdapter.data = data
        analysisAdapter.notifyDataSetChanged()

        rv_managefrag_analysislist.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = analysisAdapter
        }

        setPieChart()
    }

}