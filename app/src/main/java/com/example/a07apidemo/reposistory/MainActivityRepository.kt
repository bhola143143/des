package com.example.a07apidemo.reposistory

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.a07apidemo.model.Data
import com.example.a07apidemo.retrofit.RetrofitClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<Data>()

    fun getServicesApiCall(): MutableLiveData<Data> {

        val call = RetrofitClient.apiInterface.primary(






        )

        Log.v("bhola : ", call.toString())

        call.enqueue(object : Callback<Data> {
            override fun onFailure(call: Call<Data>, t: Throwable) {

                Log.v("DEBUG : ", t.toString())

            }

            override fun onResponse(
                call: Call<Data>,
                response: Response<Data>
            ) {

                Log.v("DEBUG : ", response.body().toString())

                val primary = response.body()
                val responseData = primary?.data
                val message = primary?.message
                val status = primary?.status
                val statusCode = primary?.status_code


                serviceSetterGetter.value = Data(responseData, message, status, statusCode)


            }
        })


        return serviceSetterGetter
    }


}