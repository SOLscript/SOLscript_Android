package com.good.solscript.data

import com.good.solscript.data.remote.SampleRemoteDataSource
import io.reactivex.Single
import retrofit2.Call

class SampleRepository {

    fun postChatDatas(postChatRequest: PostChatRequest):Single<ChatData> =
        SampleRemoteDataSource.postChatData(postChatRequest)

    fun getCategoryDatas(category: String):Single<ResponseCategory> =
        SampleRemoteDataSource.getCategoryData(category)

    fun getRecommandDatas():Single<ResponseRecommand> =
        SampleRemoteDataSource.getRecommandData()
    fun getTotalMoneyDatas(month : Int) : Call<ResponseTotalMoneyData> =
        SampleRemoteDataSource.sampleRetrofit.getTotalMoney(month)

    fun getCategoryTotalMoneyDatas(month : Int) : Call<ResponseCategoryTotalData> =
        SampleRemoteDataSource.sampleRetrofit.getCategoryMoney(month)


    fun postRegisterCardData(cardInfo : PostCardRequest) : Call<ResponseRegisterCard> =
        SampleRemoteDataSource.sampleRetrofit.postRegisterCard(cardInfo)
}