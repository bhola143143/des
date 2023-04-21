package com.example.a07apidemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a07apidemo.model.Data
import com.example.a07apidemo.reposistory.MainActivityRepository


class MainActivityViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<Data>? = null

    fun getUser(): LiveData<Data>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }


}