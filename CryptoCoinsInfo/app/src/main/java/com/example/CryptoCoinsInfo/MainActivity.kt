package com.example.CryptoCoinsInfo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.CryptoCoinsInfo.models.coinsApiItem
import com.example.CryptoCoinsInfo.network.CoinsApi
import com.example.CryptoCoinsInfo.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter: RecyclerViewAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setCryptoLists()
    }


    private fun setCryptoLists() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        getCoins()
    }

    private fun getCoins() {

        try {
            val retrofitData = CoinsApi.retrofitServiceCoinsApi.getData()
            retrofitData.enqueue(object : Callback<List<coinsApiItem>?> {

                override fun onResponse(
                    call: Call<List<coinsApiItem>?>,
                    response: Response<List<coinsApiItem>?>,

                    ) {

                    val responseBody = response.body()
                    responseBody?.let {
                        mAdapter = RecyclerViewAdapter(it)
                        binding.recyclerView.adapter = mAdapter
                    }

                }

                override fun onFailure(call: Call<List<coinsApiItem>?>, t: Throwable) {
                    Log.d("MainActivity", "onFailure:" + t.message)

                }
            })
        } catch (e: IOException){}
    }

//    fun isActiveTextView(view: View) {
//        val intent= Intent(this,coinsDetails::class.java)
//        Toast.makeText(this,"Coin Is Active",Toast.LENGTH_SHORT).show()
//    }
}
