package com.good.solscript.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.good.solscript.R
import com.good.solscript.data.PostCardRequest
import com.good.solscript.data.ResponseRegisterCard
import com.good.solscript.data.SampleRepository
import kotlinx.android.synthetic.main.activity_card_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardInfoActivity : AppCompatActivity() {

    private val repository by lazy { SampleRepository() }

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

            postRegisterCardData(PostCardRequest(et_cardinfoact_cardnum.text.toString(), et_cardinfoact_cvc2.text.toString(),et_cardinfoact_valid.text.toString(),et_cardinfoact_password.text.toString()))
            //등록통신
        }


    }

    private fun postRegisterCardData(cardInfo : PostCardRequest){
        repository.postRegisterCardData(cardInfo).enqueue(
            object : Callback<ResponseRegisterCard> {
                override fun onFailure(call: Call<ResponseRegisterCard>, t: Throwable) {
                    Log.e("cardInfo", t.toString())
                }

                override fun onResponse(
                    call: Call<ResponseRegisterCard>,
                    response: Response<ResponseRegisterCard>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()

                        data?.let {
                            Log.e("cardInfo", it.dataHeader.resultMessage)
                            finish()
                        }
                    }
                }

            }
        )
    }
}
