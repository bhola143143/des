package com.example.a07apidemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a07apidemo.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var context: Context

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.getUser()!!.observe(this, Observer { serviceSetterGetter ->


            val settings = serviceSetterGetter.data
            



            Log.d("@@@ Settings: ", "$settings")

        })
    }
}