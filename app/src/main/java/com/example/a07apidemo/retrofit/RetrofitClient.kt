package com.example.a07apidemo.retrofit


import com.example.a07apidemo.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    const val base_url = "https://encoreapi.demo.brainvire.dev/api/"



    val retrofitClient: Retrofit.Builder by lazy {

        val levelType: HttpLoggingInterceptor.Level
        if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
            levelType = HttpLoggingInterceptor.Level.BODY else levelType = HttpLoggingInterceptor.Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)

        okhttpClient.addInterceptor { chain ->
            val request: Request =
                chain.request().newBuilder()
                    .addHeader("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ2YWwiOjE4MDgsImlkIjoxNDMyLCJ1c2VyQ29udGFjdCI6IisxOTQ5Mjg4MzUyMyIsInVzZXJTU04iOiI2MDU2Njk4OSIsInVzZXJQYXJlbnRfSUQiOjAsIm9wZXJhdGlvblR5cGUiOiJTSUdOSU4iLCJpYXQiOjE2ODA4NDY0NDYsImV4cCI6MTY4MTI3ODQ0Nn0.MjtrdZ9-r4PNPdGlzz7MlipBSvqIdtGQBwLtkJrBhWw").build()
            chain.proceed(request)
        }



        Retrofit.Builder()
            .baseUrl(base_url)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: ApiInterface by lazy {
        retrofitClient
            .build()
            .create(ApiInterface::class.java)
    }


}
