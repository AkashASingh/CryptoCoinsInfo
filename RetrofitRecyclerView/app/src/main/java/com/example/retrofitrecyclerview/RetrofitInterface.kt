package com.example.retrofitrecyclerview

import retrofit2.Call
import retrofit2.http.GET


interface RetrofitInterface {
    @GET("coins")
    fun getData() : Call<List<CoinsApiItem>>
}