package com.dmitrystonie.leasingapp.carlooking.di

import com.dmitrystonie.leasingapp.carlooking.data.datasource.RemoteCarsDataSource
import com.dmitrystonie.leasingapp.carlooking.data.network.CarsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.dmitrystonie.leasingapp.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
object RetrofitMoonModule {

    @Provides
    fun providesBaseUrl(): String = BuildConfig.LEASING_API_BASE_URL

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