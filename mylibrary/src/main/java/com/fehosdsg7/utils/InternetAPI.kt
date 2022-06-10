package com.fehosdsg7.utils

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path


interface CmuAPI {
    @POST("{link}/?gaid")
    suspend fun getData(@Path(value = "link") link : String, @Body chupa : Chupoa) : Daonm
}