package com.dmitrystonie.leasingapp.leasing.data.datasource.dto

data class PaginationMeta(
    val total: Int,
    val page: Int,
    val limit: Int,
    val totalPages: Int,
)