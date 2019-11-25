package com.good.solscript.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.good.solscript.R
import kotlinx.android.synthetic.main.activity_mypage.*
import org.jetbrains.anko.startActivity

class MypageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        rl_mypageact_card.setOnClickListener {
            startActivity<CardActivity>()
        }

        iv_mypageact_backbtn.setOnClickListener {
            finish()
        }

    }
}
