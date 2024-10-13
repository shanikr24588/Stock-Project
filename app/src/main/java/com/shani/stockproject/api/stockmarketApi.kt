package com.shani.stockmarketproject.api

import com.shani.stockmarketproject.Model.apiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface stockMarketApi {
    @GET("query?function=TIME_SERIES_DAILY")
    suspend fun getStockData(
        @Query("symbol") symbol : String,
        @Query("apikey") key: String
    ): Response<apiResponse>


}