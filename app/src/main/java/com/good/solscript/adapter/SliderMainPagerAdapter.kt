package com.good.solscript.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.good.solscript.R
import com.good.solscript.ui.SliderMainFragment

class SliderMainPagerAdapter(fm: FragmentManager, private val num_fragment: Int) :
    FragmentPagerAdapter(
        fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    override fun getItem(p0: Int): Fragment {

        //보여질 fragment들은 모두 같은 클래스 상속
        val fragment = SliderMainFragment()

        //한 개 bundle에 담길 데이터의 개수 지정
        val bundle = Bundle()

        //Fragment별 배경이미지 지정
        when (p0) {
            0 -> bundle.putInt(
                "background_url",
                R.drawable.category_banner_3
            )
            1 -> bundle.putInt(
                "background_url",
                R.drawable.category_banner_2
            )
            2 -> bundle.putInt(
                "background_url",
                R.drawable.category_banner_3
            )
        }
        //Bundle 객체를 arguments에 전달
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int = num_fragment

}