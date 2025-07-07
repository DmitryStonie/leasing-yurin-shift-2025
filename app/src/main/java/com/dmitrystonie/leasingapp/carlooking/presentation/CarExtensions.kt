package com.dmitrystonie.leasingapp.carlooking.presentation

import android.util.Log
import com.dmitrystonie.leasingapp.BuildConfig
import com.dmitrystonie.leasingapp.domain.entity.car.Car

fun Car.getCoverImageUrl(): String {
    Log.d("INFO", "${BuildConfig.LEASING_IMAGES_BASE_URL}${this.media.first { media -> media.isCover == true }.url}")
    return "${BuildConfig.LEASING_IMAGES_BASE_URL}${this.media.first { media -> media.isCover == true }.url}"
}