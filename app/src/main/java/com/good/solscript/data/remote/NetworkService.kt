package com.good.solscript.data.remote

import com.good.solscript.data.*
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkService {

    @POST("/dialogflow")
    fun postChatBot(@Body credentials: PostChatRequest): Single<ChatData>

    @GET("/search/{category}")
    fun getCategoryList(@Path("category") category: String): Single<ResponseCategory>

    @GET("/home")
    fun getRecommand(): Single<ResponseRecommand>

    @GET("/mypage/search/calender/{month}")
    fun getTotalMoney(
        @Path("month") month: Int
    ): Call<ResponseTotalMoneyData>

    @GET("/mypage/search/cost/{month}")
    fun getCategoryMoney(
        @Path("month") month: Int
    ): Call<ResponseCategoryTotalData>

    @POST("/regist/shinhanCard")
    fun postRegisterCard(
        @Body body: PostCardRequest
    ): Call<ResponseRegisterCard>
}