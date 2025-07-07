package com.dmitrystonie.leasingapp.carlooking.di

import com.dmitrystonie.leasingapp.carlooking.data.datasource.RemoteCarsDataSource
import com.dmitrystonie.leasingapp.carlooking.data.network.CarsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitMoonModule {

    @Provides
    fun providesBaseUrl(): String = "https://shift-intensive.ru/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl : String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    @Provides
    @Singleton
    fun provideCarsService(retrofit: Retrofit): CarsService = retrofit.create(CarsService::class.java)

    @Provides
    @Singleton
    fun provideCarsRemoteData(carsService: CarsService): RemoteCarsDataSource =
        RemoteCarsDataSource(carsService)
}