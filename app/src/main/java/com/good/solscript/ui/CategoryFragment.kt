package com.good.solscript.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.good.solscript.R
import com.good.solscript.adapter.SliderMainPagerAdapter
import kotlinx.android.synthetic.main.fragment_category.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("onCreateView", "categoryFragment")
        return inflater.inflate(R.layout.fragment_category, container, false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //configureMainTab()
        Log.d("onActivityCreated", "categoryFragment")

        vp_main_slider.adapter = SliderMainPagerAdapter(childFragmentManager, 3)
        vp_main_slider.offscreenPageLimit = 2
        tl_main_indicator.setupWithViewPager(vp_main_slider)

        ll_category_entertain.onClick {
            startActivity<CategoryContentActivity>()
        }

    }
}
