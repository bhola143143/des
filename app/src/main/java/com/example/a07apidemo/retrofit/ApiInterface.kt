package com.example.a07apidemo.retrofit

import com.example.a07apidemo.model.Data
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("disease/primaryCare")
    fun primary(


    ): Call<Data>


    /*https://encoreapi.demo.brainvire.dev/api/user/signIn*/
}