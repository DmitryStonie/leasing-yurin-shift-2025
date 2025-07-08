package com.dmitrystonie.leasingapp.leasing.di

import com.dmitrystonie.leasingapp.leasing.data.datasource.CarRentDataSource
import com.dmitrystonie.leasingapp.network.LeasingService
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
    fun provideLeasingService(retrofit: Retrofit): LeasingService =
        retrofit.create(LeasingService::class.java)

    @Provides
    @Singleton
    fun provideRentRemoteData(leasingService: LeasingService): CarRentDataSource =
        CarRentDataSource(leasingService)
}