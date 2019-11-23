package com.good.solscript.data.remote

import com.good.solscript.data.*
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkService {

    @GET("/posts")
    fun getSample(): Call<List<SampleData>>

    @GET("/posts")
    fun getFakeDatas(): Single<List<SampleData>>

    @POST("/dialogflow")
    fun postChatBot(@Body credentials: PostChatRequest): Single<ChatData>

    @GET("/mypage/search/calender/{month}")
    fun getTotalMoney(
        @Path("month") month : Int
    ) : Call<ResponseTotalMoneyData>

    @GET("/mypage/search/cost/{month}")
    fun getCategoryMoney(
        @Path("month") month : Int
    ) : Call<ResponseCategoryTotalData>

    @POST("/regist/shinhanCard")
    fun postRegisterCard(
        @Body body: PostCardRequest
    ) : Call<ResponseRegisterCard>
}