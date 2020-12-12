package com.example.casonovaera.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {

        private const val URL_BASE = " https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"
        fun getRetrofitClient() : productosApi {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(productosApi::class.java)
        }
    }


}