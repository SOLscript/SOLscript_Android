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
import com.good.solscript.data.ResponseTotalMoneyData
import com.good.solscript.data.SampleRepository
import com.good.solscript.data.SelectedData
import com.good.solscript.data.SubscriptData
import com.prolificinteractive.materialcalendarview.CalendarDay
import kotlinx.android.synthetic.main.fragment_subscript_calendar.*
import org.jetbrains.anko.support.v4.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
                fab_calendarfrag_showlist.setImageResource(R.drawable.icons_8_calendar_96_1)

            } else {
                rv_calendarfrag_samplelist.visibility = View.GONE
                cl_calendarfrag_containier.visibility = View.VISIBLE
                fab_calendarfrag_showlist.setImageResource(R.drawable.icons_8_list_96)
            }
        }

        getTotalMoneyResponse(11)

        cv_calendarfrag_calendar.setOnMonthChangedListener { widget, date ->
            Log.e(CALENDARFRAGMENT,"ㅎㅇ "+ date.month.toString()+"ㅎㅎ" +date)
            getTotalMoneyResponse(date.month+1)
        }

    }

    private fun getTotalMoneyResponse(month : Int){
        repository.getTotalMoneyDatas(month).enqueue(
            object : Callback<ResponseTotalMoneyData> {
                override fun onFailure(call: Call<ResponseTotalMoneyData>, t: Throwable) {
                    Log.e(CALENDARFRAGMENT, t.toString())
                }

                override fun onResponse(
                    call: Call<ResponseTotalMoneyData>,
                    response: Response<ResponseTotalMoneyData>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        Log.e(CALENDARFRAGMENT, data.toString())
                        Log.e(CALENDARFRAGMENT, data!!.totalMoney.toString())

                        data?.let {

                            tv_calendarfrag_totalmoney.text = " "+ it.totalMoney.toString() + " 원"
                            settingCalendarView(it)

                        }
                    }
                }

            }
        )
    }

    private fun settingCalendarView(data : ResponseTotalMoneyData){

        var dates: ArrayList<CalendarDay> = ArrayList()

        var monthDateArrayList=  data.message
        val dataList = arrayListOf<SelectedData>()


        for( (i, dayData) in monthDateArrayList.withIndex()){

            var day = dayData.date.split("-")

            var calendarDay = CalendarDay.from(day[0].toInt(),day[1].toInt()+1,day[2].toInt())

            dates.add(calendarDay)
            cv_calendarfrag_calendar.addDecorator(EventDecorator(Color.BLUE, dates))
            Log.e("tag","calendarDay"+calendarDay.toString())

            for ((j,detailData) in monthDateArrayList[i].subList.withIndex()){

                dataList.add(
                    SelectedData(
                        detailData.title,
                        "${calendarDay.year}/${calendarDay.month}/${calendarDay.day}",
                        "0",
                        detailData.image,
                        detailData.price.toString(),
                        "매 달 갱신"
                    )
                )
            }
        }

        selectedAdapter.data = dataList
        selectedAdapter.notifyDataSetChanged()

        rv_calendarfrag_selectedlist.apply {
            layoutManager = LinearLayoutManager(activity?.applicationContext)
            adapter = selectedAdapter
        }

    }

    private fun setCalendarView() {

        var dates: ArrayList<CalendarDay> = ArrayList()

        dates.add(CalendarDay.from(2019, 9, 23))
        dates.add(CalendarDay.from(2019, 9, 14))
        dates.add(CalendarDay.from(2019, 9, 11))
        dates.add(CalendarDay.from(2019, 9,3))


        dates.add(CalendarDay.from(2019, 10, 23))
        dates.add(CalendarDay.from(2019, 10, 14))
        dates.add(CalendarDay.from(2019, 10, 11))
        dates.add(CalendarDay.from(2019, 10,3))

        cv_calendarfrag_calendar.addDecorator(EventDecorator(Color.BLUE, dates))

/*
        val dataList = arrayListOf<SelectedData>()
        dataList.add(
            SelectedData(
                "Naver Cloud",
                "${calendarDay.year}/${calendarDay.month}/${calendarDay.day}",
                "0",
                detailData.image,
                "8,000 원",
                "매 달 갱신"
            )
        )
*/


        cv_calendarfrag_calendar.addDecorator(EventDecorator(Color.BLUE, dates))

        cv_calendarfrag_calendar.setOnDateChangedListener { widget, date, selected ->
            Toast.makeText(
                context,
                "${date.year}년  ${date.month+1}월 ${date.day}일",
                Toast.LENGTH_SHORT
            ).show()

            rl_calenderfrag_selectedcontainer.visibility = View.VISIBLE
            setCalendarSelectedRecyclerView(date)
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
            SubscriptData("https://images-na.ssl-images-amazon.com/images/I/41Ix1vMUK7L._SY355_.png", "Netflix",
                0, 7000, "1달", "10월 11일", "11월 12일")
        )
        dataList.add(
            SubscriptData(
                "https://modoctest.s3.ap-northeast-2.amazonaws.com/1574519728123.png",
                "풀무원",
                1,
                9900,
                "1달",
                "10월 13일",
                "11월 14일"
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
                "https://modoctest.s3.ap-northeast-2.amazonaws.com/1574507149865.jpeg",
                "Google Cloud",
                0,
                3000,
                "1달",
                "10월 10일",
                "11월 11일"
            )
        )
        dataList.add(
            SubscriptData(
                "https://modoctest.s3.ap-northeast-2.amazonaws.com/1574507027962.jpeg",
                "Naver Cloud",
                1,
                10000,
                "1달",
                "10월 12일",
                "11월 13일"
            )
        )
        dataList.add(
            SubscriptData(
                "https://modoctest.s3.ap-northeast-2.amazonaws.com/1574506673972.png",
                "Youtube",
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