package com.good.solscript.data.remote

import com.good.solscript.data.ChatData
import com.good.solscript.data.PostChatRequest
import com.good.solscript.data.ResponseCategory
import com.good.solscript.data.ResponseRecommand
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object SampleRemoteDataSource {
    private const val SAMPLE_URL = "https://jsonplaceholder.typicode.com"
    private const val CHAT_URL = "https://210f7a0c.ngrok.io"
    private const val BASE_URL = "https://5ab52606.ngrok.io"


    val sampleRetrofit: NetworkService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NetworkService::class.java)

    private val rxRetrofit: NetworkService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NetworkService::class.java)

    private val rxChatRetrofit: NetworkService = Retrofit.Builder()
        .baseUrl(CHAT_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NetworkService::class.java)

    fun postChatData(postChatRequest: PostChatRequest): Single<ChatData> =
        rxChatRetrofit.postChatBot(postChatRequest)
            .subscribeOn(Schedulers.io())

    fun getCategoryData(category: String): Single<ResponseCategory> =
        rxRetrofit.getCategoryList(category)
            .subscribeOn(Schedulers.io())

    fun getRecommandData():Single<ResponseRecommand> =
        rxRetrofit.getRecommand()
            .subscribeOn(Schedulers.io())

}