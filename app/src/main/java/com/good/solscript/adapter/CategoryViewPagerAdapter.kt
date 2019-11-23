package com.good.solscript.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.good.solscript.ui.CategoryContentFragment

class CategoryViewPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val categoryList =
        listOf("엔터테인", "생필품", "식품", "반려동물", "유아동", "디지털", "취미/도서", "홈데코", "패션의류")

    override fun getItem(position: Int): Fragment =
        CategoryContentFragment.newInstance(categoryList[position])

    override fun getCount(): Int = categoryList.size

    override fun getPageTitle(position: Int): CharSequence? = categoryList[position]
}
