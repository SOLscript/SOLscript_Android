package com.good.solscript.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.net.Uri
import com.good.solscript.R
import kotlinx.android.synthetic.main.activity_detailed.*


class DetailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        iv_detailedact_heartselector.setOnClickListener {
            if(iv_detailedact_heartselector.isSelected){
                iv_detailedact_heartselector.isSelected = false
            }else
                iv_detailedact_heartselector.isSelected = true
        }

        tv_detailedact_description.setOnClickListener {
            val url = "http://gun0912.tistory.com"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}
