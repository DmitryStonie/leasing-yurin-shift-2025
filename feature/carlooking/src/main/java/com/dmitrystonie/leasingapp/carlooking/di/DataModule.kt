package com.dmitrystonie.leasingapp.carlooking.di

import com.dmitrystonie.leasingapp.carlooking.data.repository.CarsRepositoryImpl
import com.dmitrystonie.leasingapp.carlooking.domain.repository.CarsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun provideCarsRepository(carsRepositoryImpl: CarsRepositoryImpl): CarsRepository

}