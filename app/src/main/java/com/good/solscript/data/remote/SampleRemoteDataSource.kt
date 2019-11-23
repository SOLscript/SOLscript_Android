package com.good.solscript.data.remote

import com.good.solscript.data.ChatData
import com.good.solscript.data.PostChatRequest
import com.good.solscript.data.SampleData
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object SampleRemoteDataSource {
    private const val SAMPLE_URL = "https://jsonplaceholder.typicode.com"
    private const val CHAT_URL = "https://d4d4ac74.ngrok.io"
    private const val BASE_URL = "https://5ab52606.ngrok.io"


    val sampleRetrofit: NetworkService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NetworkService::class.java)

    //val service : NetworkService = sampleRetrofit.create(NetworkService::class.java)

    val rxRetrofit: NetworkService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NetworkService::class.java)

    val rxChatRetrofit: NetworkService = Retrofit.Builder()
        .baseUrl(CHAT_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NetworkService::class.java)

    fun getFakeData(): Single<List<SampleData>> =
        rxRetrofit.getFakeDatas()
            .subscribeOn(Schedulers.io())

    fun postChatData(postChatRequest: PostChatRequest): Single<ChatData> =
        rxChatRetrofit.postChatBot(postChatRequest)
            .subscribeOn(Schedulers.io())
}