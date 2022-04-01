package com.example.myapp

data class TestingDataClass(
    val `data`: List<DataX>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)