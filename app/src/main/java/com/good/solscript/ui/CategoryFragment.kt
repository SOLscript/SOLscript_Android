package com.good.solscript.ui


import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
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
            startActivity<CategoryContentActivity>("tabNumber" to 0)
        }
        ll_category_dailynecessity.onClick {
            startActivity<CategoryContentActivity>("tabNumber" to 1)
        }
        ll_category_food.onClick {
            startActivity<CategoryContentActivity>("tabNumber" to 2)
        }
        ll_category_animal.onClick {
            startActivity<CategoryContentActivity>("tabNumber" to 3)
        }
        ll_category_baby.onClick {
            startActivity<CategoryContentActivity>("tabNumber" to 4)
        }
        ll_category_digital.onClick {
            startActivity<CategoryContentActivity>("tabNumber" to 5)
        }
        ll_category_hobby.onClick {
            startActivity<DetailedActivity>()
        }
        ll_category_homedeco.onClick {
            startActivity<CategoryContentActivity>("tabNumber" to 7)
        }
        ll_category_clothing.onClick {
            startActivity<CategoryContentActivity>("tabNumber" to 8)
        }

        iv_enter.background = ShapeDrawable(OvalShape())
        iv_enter.clipToOutline = true
    }
}
