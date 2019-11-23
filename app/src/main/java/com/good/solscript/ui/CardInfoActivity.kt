package com.good.solscript.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.good.solscript.R
import kotlinx.android.synthetic.main.activity_card_info.*

class CardInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_info)


        iv_cardinfoact_backbtn.setOnClickListener {
            finish()
        }

        tv_cardinfoact_registerbtn.setOnClickListener {

            et_cardinfoact_cardnum.text.toString()
            et_cardinfoact_cvc2.text.toString()
            et_cardinfoact_valid.text.toString()
            et_cardinfoact_password.text.toString()

            finish()
            //등록통신
        }
    }
}
