package com.sagar.android.servicedemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ServiceOne : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(
            "serviceDemo",
            Thread.currentThread().id.toString()
        )
        stopSelf()

        /*
        the value you return here decides what happens to the service if it got killed by the
        android OS and again re started by the OS.

                                Auto start      Intent
        start sticky            YES             No
        sticky not sticky         
         */
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}
