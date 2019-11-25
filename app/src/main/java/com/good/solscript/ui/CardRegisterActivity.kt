package com.good.solscript.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.good.solscript.R
import kotlinx.android.synthetic.main.activity_card_register.*
import org.jetbrains.anko.startActivity

class CardRegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_register)

        iv_registeract_backbtn.setOnClickListener {
            finish()
        }

        rl_registeract_bankbtn.setOnClickListener {
            startActivity<CardInfoActivity>()
            finish()
        }

        rl_registeract_cardbtn.setOnClickListener {
            startActivity<CardInfoActivity>()
            finish()
        }


    }
}
