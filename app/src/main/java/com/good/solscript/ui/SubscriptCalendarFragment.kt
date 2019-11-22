package com.good.solscript.ui


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.good.solscript.R
import com.good.solscript.adapter.SelectedAdapter
import com.good.solscript.adapter.SubscriptListAdapter
import com.good.solscript.data.SampleRepository
import com.good.solscript.data.SelectedData
import com.good.solscript.data.SubscriptData
import com.prolificinteractive.materialcalendarview.CalendarDay
import kotlinx.android.synthetic.main.fragment_subscript_calendar.*
import org.jetbrains.anko.support.v4.startActivity
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class SubscriptCalendarFragment : Fragment() {

    val CALENDARFRAGMENT = "calendarFragment:"
    private val repository by lazy { SampleRepository() }
    //private val sampleAdapter by lazy { SampleAdapter() }

    private val selectedAdapter by lazy { SelectedAdapter() }
    private val subscriptAdapter by lazy { SubscriptListAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("onCreateView", "SubscriptCalendarFragment")
        return inflater.inflate(R.layout.fragment_subscript_calendar, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //getSampleResponse()
        setCalendarView()
        setSubscriptRecyclerView()

        tv_calendarfrag_analysisbtn.setOnClickListener {
            startActivity<AnalysisActivity>()
        }

        fab_calendarfrag_showlist.setOnClickListener {

            if (cl_calendarfrag_containier.visibility == View.VISIBLE) {
                cl_calendarfrag_containier.visibility = View.GONE
                rv_calendarfrag_samplelist.visibility = View.VISIBLE
            } else {
                rv_calendarfrag_samplelist.visibility = View.GONE
                cl_calendarfrag_containier.visibility = View.VISIBLE

            }
        }
    }

/*    private fun getSampleResponse() {
        repository.getSampleDates().enqueue(
            object : Callback<List<SampleData>> {
                override fun onFailure(call: Call<List<SampleData>>, t: Throwable) {
                    Log.e(CALENDARFRAGMENT, t.toString())
                }

                override fun onResponse(
                    call: Call<List<SampleData>>, response: Response<List<SampleData>>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        data?.let { setRecyclerView(it) }
                    }
                }
            }
        )
    }*/

/*    fun setRecyclerView(data: List<SampleData>) {

        sampleAdapter.data = data
        sampleAdapter.notifyDataSetChanged()

        rv_calendarfrag_samplelist.apply {
            layoutManager = LinearLayoutManager(activity?.applicationContext)
            adapter = sampleAdapter
        }
    }*/

    private fun setCalendarView() {

        var dates: ArrayList<CalendarDay> = ArrayList()

        cv_calendarfrag_calendar.setOnDateChangedListener { widget, date, selected ->
            Toast.makeText(
                context,
                "${date.year}년  ${date.month}월 ${date.day}일",
                Toast.LENGTH_SHORT
            ).show()

            rl_calenderfrag_selectedcontainer.visibility = View.VISIBLE
            setCalendarSelectedRecyclerView(date)

            dates.add(CalendarDay.from(date.year, date.month, date.day))
            cv_calendarfrag_calendar.addDecorator(EventDecorator(Color.MAGENTA, dates))
        }

    }

    private fun setCalendarSelectedRecyclerView(date: CalendarDay) {

        val dataList = arrayListOf<SelectedData>()

        dataList.add(
            SelectedData(
                "Netflix",
                "${date.year}/${date.month}/${date.day}",
                "0",
                "https://images-na.ssl-images-amazon.com/images/I/41Ix1vMUK7L._SY355_.png",
                "9,500원",
                "매 달 갱신"
            )
        )
        dataList.add(
            SelectedData(
                "베이컨박스",
                "${date.year}/${date.month}/${date.day}",
                "0",
                "https://image.rocketpunch.com/company/37100/baconcompany_logo_1553485713.jpg?s=400x400&t=inside",
                "32,400원",
                "매 달 갱신"
            )
        )
        dataList.add(
            SelectedData(
                "플로",
                "${date.year}/${date.month}/${date.day}",
                "0",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwVpuJ5FE7wCdDI44kbt5Pyemr__xKFng1QX2vwa6GRZox_KPJ&s",
                "9,500원",
                "매 달 갱신"
            )
        )

        selectedAdapter.data = dataList
        selectedAdapter.notifyDataSetChanged()

        rv_calendarfrag_selectedlist.apply {
            layoutManager = LinearLayoutManager(activity?.applicationContext)
            adapter = selectedAdapter
        }
    }

    private fun setSubscriptRecyclerView() {

        val dataList = arrayListOf<SubscriptData>()
        dataList.add(
            SubscriptData(
                "https://images-na.ssl-images-amazon.com/images/I/41Ix1vMUK7L._SY355_.png",
                "Netflix",
                0,
                7000,
                "1달",
                "10월 11일",
                "11월 12일"
            )
        )
        dataList.add(
            SubscriptData(
                "https://image.rocketpunch.com/company/37100/baconcompany_logo_1553485713.jpg?s=400x400&t=inside",
                "베이컨박스",
                1,
                10000,
                "1달",
                "10월 12일",
                "11월 13일"
            )
        )
        dataList.add(
            SubscriptData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwVpuJ5FE7wCdDI44kbt5Pyemr__xKFng1QX2vwa6GRZox_KPJ&s",
                "플로",
                2,
                2000,
                "1달",
                "10월 28일",
                "11월 29일"
            )
        )
        dataList.add(
            SubscriptData(
                "https://images-na.ssl-images-amazon.com/images/I/41Ix1vMUK7L._SY355_.png",
                "Netflix",
                0,
                7000,
                "1달",
                "10월 11일",
                "11월 12일"
            )
        )
        dataList.add(
            SubscriptData(
                "https://image.rocketpunch.com/company/37100/baconcompany_logo_1553485713.jpg?s=400x400&t=inside",
                "베이컨박스",
                1,
                10000,
                "1달",
                "10월 12일",
                "11월 13일"
            )
        )
        dataList.add(
            SubscriptData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwVpuJ5FE7wCdDI44kbt5Pyemr__xKFng1QX2vwa6GRZox_KPJ&s",
                "플로",
                2,
                2000,
                "1달",
                "10월 28일",
                "11월 29일"
            )
        )

        subscriptAdapter.data = dataList
        subscriptAdapter.notifyDataSetChanged()

        rv_calendarfrag_samplelist.apply {
            layoutManager = LinearLayoutManager(activity?.applicationContext)
            adapter = subscriptAdapter
        }

    }
}
