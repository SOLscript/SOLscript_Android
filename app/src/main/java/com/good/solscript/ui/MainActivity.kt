package com.good.solscript.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.good.solscript.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.image


class MainActivity : AppCompatActivity() {

    private lateinit var nowFrag: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_maintab_home.setImageResource(R.drawable.tab_ic_home_pink)
        callFragment(1)
        setClickListener()

    }

    fun setClickListener() {
        rl_mainact_homebtn.setOnClickListener {
            callFragment(1)
        }

        rl_mainact_subscribebtn.setOnClickListener {
            callFragment(2)
        }

        rl_mainact_categorybtn.setOnClickListener {
            callFragment(3)
        }

    }

    private fun callFragment(frag: Int) {

        when (frag) {
            1 -> {
                iv_maintab_home.setImageResource(R.drawable.tab_ic_home_pink)
                iv_maintab_categoty.setImageResource(R.drawable.tab_ic_category_grey)
                iv_maintab_mysub.setImageResource(R.drawable.tab_ic_mysub_grey)
                nowFrag = HomeFragment()
            }

            2 -> {
                iv_maintab_home.setImageResource(R.drawable.tab_ic_home_grey)
                iv_maintab_categoty.setImageResource(R.drawable.tab_ic_category_pink)
                iv_maintab_mysub.setImageResource(R.drawable.tab_ic_mysub_grey)
                nowFrag = CategoryFragment()
            }

            3 -> {
                iv_maintab_home.setImageResource(R.drawable.tab_ic_home_grey)
                iv_maintab_categoty.setImageResource(R.drawable.tab_ic_category_grey)
                iv_maintab_mysub.setImageResource(R.drawable.tab_ic_mysub_pink)
                nowFrag = SubscriptFragment()
            }
        }

        Log.d("callFragment", "  ")

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_mainact_container, nowFrag)
        transaction.commit()
    }
}
