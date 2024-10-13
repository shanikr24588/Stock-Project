package com.shani.stockproject

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shani.stockmarketproject.Model.Constant
import com.shani.stockmarketproject.Model.apiResponse
import com.shani.stockmarketproject.api.RetrofitInstance
import retrofit2.Response


class StockViewModel: ViewModel() {
    private val stockMarketApi = RetrofitInstance.stockMarketApi
    val stockResult = MutableLiveData<apiResponse?>()
    val isLoading = MutableLiveData<Boolean>(false)


    suspend fun getData(stock: String): Response<apiResponse>? {
        try {


                val exchanges = listOf( ".BSE", ".NSE","")
                for(exchange in exchanges){
                    val symbol = stock+exchange
                    val response = stockMarketApi.getStockData(symbol, Constant.key)
                    Log.d("response_code", response.code().toString())
                    Log.d("response_body", response.body().toString())
                    Log.d("full_response", response.raw().toString())
                    if (response.isSuccessful) {
                         val body = response.body()
                         if(body?.metaData != null &&body.timeSeriesDaily !=null){
                             Log.d("symbol", response.body()?.metaData?.information.toString())
                             //stockResult.postValue(response.body())
                             return response
                         }



                        }

                    }


        }catch(e:Exception){
            Log.d("error",e.message.toString())
        }
        return null
    }
    fun resetResult(){
        stockResult.value = null
    }
}