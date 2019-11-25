package com.good.solscript.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.good.solscript.R
import kotlinx.android.synthetic.main.activity_card.*
import org.jetbrains.anko.startActivity

class CardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        tv_cardact_addbtn.setOnClickListener {
            startActivity<CardRegisterActivity>()
        }

        iv_cardact_backbtn.setOnClickListener {
            finish()
        }
    }
}
