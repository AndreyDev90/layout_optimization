package com.fehosdsg7.utils

import android.os.Parcelable
import androidx.annotation.Keep
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.parcelize.Parcelize
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object Networking {

    private val okhttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://app.njatrack.tech/session/v2.0/b068af5c-48ae-43e5-a881-363fad1f7b32/?gaid")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okhttpClient)
        .build()

    val greySourceApi: CmuAPI
        get() = retrofit.create()
}

@Parcelize
@Keep
data class Chupoa(val appsflyer : Aps, val facebook : Fb) : Parcelable

@Parcelize
@Keep
data class Aps(val data : String = "null", val none : String = "null") : Parcelable

@Parcelize
@Keep
data class Fb(val redirect_response_data : String? = null, val engmnt_source : String? = null, val retargeting_conversion_type : String = "none") : Parcelable

@Parcelize
@Keep
data class Daonm(val client_id : String, val session_id : String, val response : String?, val message : String): Parcelable{
    companion object {
        fun Daonm.toApp(): App {
            return App("", "", this.response)
        }
    }
}
