package com.dmitrystonie.leasingapp.carlooking.data.datasource.dto

data class PaginationMeta(
    val total: Int,
    val page: Int,
    val limit: Int,
    val totalPages: Int,
)