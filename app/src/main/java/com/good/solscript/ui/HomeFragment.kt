package com.good.solscript.ui


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.good.solscript.R
import com.good.solscript.adapter.RecommandAdapter
import com.good.solscript.data.ResponseRecommandSubData
import com.good.solscript.data.SampleRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var nowFrag: Fragment
    private val recommandAdapter by lazy { RecommandAdapter() }
    private val repository by lazy { SampleRepository() }
    private val recommandList = mutableListOf<ResponseRecommandSubData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fab_homefrag_chatbtn.setOnClickListener {
            startActivity<ChatActivity>()
        }

        tv_home_calender.setTextColor(Color.parseColor("#fd479e"))
        tv_home_calender.textSize = 16f
        callFragment(1)
        setClickListener()
        recyclerViewInit()
        repository.getRecommandDatas()
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.responseRecommandData.responseRecommandSubData
            }
            .subscribe({
                it.map {
                    Log.d("RecommandData",""+it)
                    recommandList.add(it)
                    recommandAdapter.setData(recommandList)
                }
            }, {
                Log.d("commandList_err", "fail " + it.message)
            })

    }
    private fun recyclerViewInit() {
        rv_recomand?.run {
            adapter = recommandAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }
    fun setClickListener() {
        rl_homefragment_calender.setOnClickListener {
            tv_home_calender.setTextColor(Color.parseColor("#fd479e"))
            tv_home_mysubscipt.setTextColor(Color.parseColor("#ffffff"))
            tv_home_used.setTextColor(Color.parseColor("#ffffff"))
            tv_home_calender.textSize = 16f
            tv_home_mysubscipt.textSize = 14f
            tv_home_used.textSize = 14f
            callFragment(1)

        }

        rl_homefragment_subscript.setOnClickListener {
            tv_home_calender.setTextColor(Color.parseColor("#ffffff"))
            tv_home_mysubscipt.setTextColor(Color.parseColor("#fd479e"))
            tv_home_used.setTextColor(Color.parseColor("#ffffff"))
            tv_home_calender.textSize = 14f
            tv_home_mysubscipt.textSize = 16f
            tv_home_used.textSize = 14f
            callFragment(2)
        }

        rl_homefragment_used.setOnClickListener {
            tv_home_calender.setTextColor(Color.parseColor("#ffffff"))
            tv_home_mysubscipt.setTextColor(Color.parseColor("#ffffff"))
            tv_home_used.setTextColor(Color.parseColor("#fd479e"))
            tv_home_calender.textSize = 14f
            tv_home_mysubscipt.textSize = 14f
            tv_home_used.textSize = 16f
            callFragment(3)
        }

    }

    private fun callFragment(frag: Int) {

        when (frag) {
            1 -> {
                nowFrag = HomeCardFragment()
            }

            2 -> {
                nowFrag = HomeSubscriptFragment()
            }

            3 -> {
                nowFrag = HomeUsedFragment()
            }
        }

        Log.d("callFragment", "  ")

        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_homefragment_container, nowFrag)
        transaction.commit()
    }
}

