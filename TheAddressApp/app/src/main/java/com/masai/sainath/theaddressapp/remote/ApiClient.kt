package com.masai.sainath.theaddressapp.remote

import com.masai.sainath.theaddressapp.remote.responses.ResponseDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {



    @GET("compassLocation/rest/address/autocomplete")
    fun getResponse(
        @Query("queryString") queryString: String,
        @Query("city") city: String
    ): Observable<ResponseDTO>
//    fun getResponse(): Observable<DataModel>
}