package com.fehosdsg7.utils

import retrofit2.http.Body
import retrofit2.http.POST


interface CmuAPI {
    @POST(".")
    suspend fun getData(@Body chupa : Chupoa) : Daonm
}