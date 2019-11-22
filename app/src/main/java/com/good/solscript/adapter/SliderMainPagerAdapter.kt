package com.good.solscript.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
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
        val bundle = Bundle(1)

        //Fragment별 배경이미지 지정
        when (p0) {
            0 -> bundle.putString(
                "background_url",
                "https://user-images.githubusercontent.com/35513039/69457669-f1c75880-0db0-11ea-8967-8b34f931c108.png"
            )
            1 -> bundle.putString(
                "background_url",
                "https://user-images.githubusercontent.com/35513039/69457669-f1c75880-0db0-11ea-8967-8b34f931c108.png"
            )
            2 -> bundle.putString(
                "background_url",
                "https://user-images.githubusercontent.com/35513039/69457669-f1c75880-0db0-11ea-8967-8b34f931c108.png"
            )
        }
        //Bundle 객체를 arguments에 전달
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int = num_fragment

}