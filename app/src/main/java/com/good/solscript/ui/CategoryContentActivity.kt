package com.good.solscript.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.good.solscript.R
import com.good.solscript.adapter.CategoryViewPagerAdapter
import kotlinx.android.synthetic.main.activity_category_content.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CategoryContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_content)

        configureMainTab()

        iv_back.onClick {
            finish()
        }
    }

    private fun configureMainTab() {
        viewpager_category_item.adapter = CategoryViewPagerAdapter(supportFragmentManager)
        tablayout_category_title.setupWithViewPager(viewpager_category_item)
    }
}
