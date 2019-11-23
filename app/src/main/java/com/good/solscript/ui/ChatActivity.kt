package com.good.solscript.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.good.solscript.R
import com.good.solscript.adapter.ChatAdapter
import com.good.solscript.data.ChatData
import com.good.solscript.data.PostChatRequest
import com.good.solscript.data.SampleRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_chat.*


class ChatActivity : AppCompatActivity() {

    private val repository by lazy { SampleRepository() }
    private val chatAdapter by lazy { ChatAdapter() }
    private val dataList = arrayListOf<ChatData>()
    private lateinit var message : String
    private var postChatRequest : PostChatRequest? = null
    private var imm: InputMethodManager? = null

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        setChatRecyclerView()

        imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?

        tv_chatact_sendbtn.setOnClickListener { sendTextMessage() }
    }

    private fun setChatRecyclerView() {

        dataList.add(ChatData("WELCOME!!", "chatbot"))

        chatAdapter.data = dataList
        chatAdapter.notifyDataSetChanged()

        rv_chatact_chatlist.apply {
            layoutManager = LinearLayoutManager(this@ChatActivity)
            adapter = chatAdapter
        }
    }

    @SuppressLint("CheckResult")
    private fun sendTextMessage() {

        message = et_chatact_inputtext.text.toString()
        chatAdapter.addItem(ChatData(message, "me"))
        et_chatact_inputtext.setText("")

        postChatRequest = PostChatRequest(message,"승희")
        repository.postChatDatas(postChatRequest!!)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("list", "chatList" + dataList)
                dataList.add(it)
                chatAdapter.notifyDataSetChanged()
            }, {
                Log.d("chatList_err", "fail" + it.message)
            })

        rv_chatact_chatlist.smoothScrollToPosition(chatAdapter.itemCount)
        imm?.hideSoftInputFromWindow(et_chatact_inputtext.windowToken, 0)
    }
}
