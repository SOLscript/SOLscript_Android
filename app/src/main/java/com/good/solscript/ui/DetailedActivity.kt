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

        tttt.setOnClickListener {
            val url = "https://www.millie.co.kr/company/company.html?_emk_keyword=%EB%B0%80%EB%A6%AC%EC%9D%98%EC%84%9C%EC%9E%AC&gclid=CjwKCAiAzuPuBRAIEiwAkkmOSNgvdErUoOhXj6gJNiCtU5e-4FfntuEW1jMMfZD2p4Lg5apBJFSH1xoC6IIQAvD_BwE#introPrice"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}
