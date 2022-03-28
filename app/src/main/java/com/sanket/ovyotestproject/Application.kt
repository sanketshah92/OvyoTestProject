package com.sanket.ovyotestproject

import android.app.Application
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class Application:Application() {


    companion object RetrofitInstance{
        fun getRetrofitInstance(): Retrofit {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor{chain ->
                    val newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "563492ad6f917000010000018dcafa6910094f99892dfc80c8788965")
                        .build()
                    chain.proceed(newRequest)
                }
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.pexels.com/").build()
        }
    }
}