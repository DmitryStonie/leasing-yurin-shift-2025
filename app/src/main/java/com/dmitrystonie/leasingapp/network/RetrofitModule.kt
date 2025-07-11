package com.dmitrystonie.leasingapp.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.dmitrystonie.leasingapp.shared.api.BuildConfig


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun providesBaseUrl(): String = BuildConfig.LEASING_API_BASE_URL

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl : String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

}