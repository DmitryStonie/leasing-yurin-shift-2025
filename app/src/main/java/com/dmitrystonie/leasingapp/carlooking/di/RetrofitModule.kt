package com.dmitrystonie.leasingapp.carlooking.di

import com.dmitrystonie.leasingapp.carlooking.data.datasource.RemoteCarsDataSource
import com.dmitrystonie.leasingapp.carlooking.data.datasource.CarsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideCarsService(retrofit: Retrofit): CarsService =
        retrofit.create(CarsService::class.java)

    @Provides
    @Singleton
    fun provideCarsRemoteData(carsService: CarsService): RemoteCarsDataSource =
        RemoteCarsDataSource(carsService)
}