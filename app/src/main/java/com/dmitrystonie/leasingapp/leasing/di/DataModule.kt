package com.dmitrystonie.leasingapp.leasing.di

import com.dmitrystonie.leasingapp.domain.repository.LeasingRepository
import com.dmitrystonie.leasingapp.leasing.data.repository.LeasingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun provideLeasingRepository(leasingRepositoryImpl: LeasingRepositoryImpl): LeasingRepository

}