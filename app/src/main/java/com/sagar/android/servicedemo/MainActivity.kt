package com.sagar.android.servicedemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var serviceIntent: Intent

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        serviceIntent = Intent(
            this,
            ServiceOne::class.java
        )

        Log.i(
            "serviceDemo",
            "Main Activity : " + Thread.currentThread().id.toString()
        )

        Handler().postDelayed(
            {
                startTheService()
            },
            5000
        )

        /*
        the service can also be stopped by stopService() method.
         */
    }

    private fun startTheService() {
        startService(
            serviceIntent
        )
    }
}
