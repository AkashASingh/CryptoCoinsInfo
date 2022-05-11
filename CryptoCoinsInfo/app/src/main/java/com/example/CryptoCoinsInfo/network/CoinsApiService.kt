package com.example.CryptoCoinsInfo.network

import com.example.CryptoCoinsInfo.models.coinsApiItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.coinpaprika.com/"

val retrofitBuilder: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CoinsApiService {

    @GET("v1/coins")
    fun getData() : Call<List<coinsApiItem>>

}
object CoinsApi {
    val retrofitServiceCoinsApi: CoinsApiService by lazy { retrofitBuilder.create(CoinsApiService::class.java)  }
}
