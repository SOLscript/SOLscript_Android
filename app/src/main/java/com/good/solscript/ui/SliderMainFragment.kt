package com.good.solscript.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.good.solscript.R
import kotlinx.android.synthetic.main.fragment_slider_main.*

class SliderMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider_main, container, false)
    }

    //Activity 생성된 후, Activity에 View가 올라간 뒤에 호출되는 생명주기
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val imgUrl: Int? = arguments?.getInt("background_url")
        //val color: Int = arguments!!.getInt("background_color")
        //img_fragment_slider_main.setBackgroundColor(color)
        Log.d("background_url", "" + imgUrl)
        Glide.with(this)
            .load(imgUrl)
            .into(img_fragment_slider_main)
    }
}