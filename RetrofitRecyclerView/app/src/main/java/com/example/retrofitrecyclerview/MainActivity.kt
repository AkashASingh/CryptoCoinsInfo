package com.example.retrofitrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitrecyclerview.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.coinpaprika.com/"

class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter: RecyclerViewAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getCoins()
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        mAdapter = RecyclerViewAdapter()
        binding.recyclerView.adapter = mAdapter


    }

    private fun getCoins() {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(RetrofitInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<CoinsApiItem>?> {
            override fun onResponse(
                call: Call<List<CoinsApiItem>?>,
                response: Response<List<CoinsApiItem>?>
            ) {

                val responseBody = response.body()!!


            }

            override fun onFailure(call: Call<List<CoinsApiItem>?>, t: Throwable) {

                Log.d("MainActivity", "onFailure:" + t.message)


            }
        })
    }
}