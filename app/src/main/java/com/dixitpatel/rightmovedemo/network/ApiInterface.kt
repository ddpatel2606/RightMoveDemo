package com.dixitpatel.rightmovedemo.network

import com.dixitpatel.rightmovedemo.model.PropertiesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *  All Network Calling Apis are define here with Coroutine function.
 */
interface ApiInterface {

    // Fetch Property list API
    @GET("properties.json")
    suspend fun fetchPropertyList(): Response<PropertiesResponse>


}