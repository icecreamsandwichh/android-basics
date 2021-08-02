package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // this is a dynamic receiver,
    // we can define and register static register in manifest file
    // they can receiver broadcast even if app is closed
    // since API 26, static broadcast receiver are not encouraged

    private lateinit var receiver : MyReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = MyReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)
        }
    }


    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}