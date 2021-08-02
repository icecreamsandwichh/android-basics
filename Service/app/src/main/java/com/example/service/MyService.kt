package com.example.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val TAG = "MyService"

    init {
        Log.d(TAG, "Service is started....")
    }

    override fun onBind(intent: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val data = intent?.getStringExtra(Constants.DATA_STRING)
        Thread {
            data?.let {
                Log.d(TAG, "onStartCommand: $data")
            }
        }.start()

        return START_STICKY

        // START_NOT_STICKY service will not be recreated if system kill it for resources
        // START_STICKY service will be recreated
        // START_REDELIVER_INTENT service will be
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Service killed....")
    }
}




























