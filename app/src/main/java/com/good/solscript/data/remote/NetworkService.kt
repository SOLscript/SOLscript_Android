package com.good.solscript.data.remote

import com.good.solscript.data.ChatData
import com.good.solscript.data.PostChatRequest
import com.good.solscript.data.SampleData
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NetworkService {

    @GET("/posts")
    fun getSample(): Call<List<SampleData>>

    @GET("/posts")
    fun getFakeDatas(): Single<List<SampleData>>

    @POST("/dialogflow")
    fun postChatBot(@Body credentials: PostChatRequest): Single<ChatData>


}