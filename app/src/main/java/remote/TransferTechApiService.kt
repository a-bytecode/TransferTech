package com.example.transferTech.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kredit.BankAcc
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://testapi.io/api/"

private val client:OkHttpClient = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val newRequest: Request = chain.request().newBuilder()
            .build()
        chain.proceed(newRequest) }.build()

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface TransferTechApiService{

    @GET("sf/v1/accounts")

    suspend fun getServerResponseBankAcc() : List<BankAcc>

    object UserApi {
        val retrofitService: TransferTechApiService by lazy { retrofit.create(TransferTechApiService::class.java) }
    }

}