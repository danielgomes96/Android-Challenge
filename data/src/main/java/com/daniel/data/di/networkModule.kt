package com.daniel.data.di

import android.util.Log
import com.daniel.core.utils.DeviceUtils.getAndroidVersion
import com.daniel.core.utils.DeviceUtils.getDeviceManufacturer
import com.daniel.core.utils.DeviceUtils.getDeviceModel
import com.daniel.data.TravelService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://private-8ac3e2-viajabessaapi5.apiary-mock.com/"

val networkModule  = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                       level = HttpLoggingInterceptor.Level.HEADERS
                    })
                    .addInterceptor { chain ->
                        val newRequest = chain.request().newBuilder()
                            .addHeader("AndroidVersion", getAndroidVersion())
                            .addHeader("DeviceManufacturer", getDeviceManufacturer())
                            .addHeader("DeviceModel", getDeviceModel())
                            .build()
                        chain.proceed(newRequest)
                    }
                    .build()
            )
            .build()
    }
    factory {
        get<Retrofit>().create(TravelService::class.java)
    }
}