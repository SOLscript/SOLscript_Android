package com.good.solscript.data.remote

import com.good.solscript.data.*
import io.reactivex.Single
import retrofit2.http.*

interface NetworkService {

    @POST("/dialogflow")
    fun postChatBot(@Body credentials: PostChatRequest): Single<ChatData>

    @GET("/search/{category}")
    fun getCategoryList(@Path("category") category: String): Single<ResponseCategory>

    @GET("/home")
    fun getRecommand(): Single<ResponseRecommand>
}