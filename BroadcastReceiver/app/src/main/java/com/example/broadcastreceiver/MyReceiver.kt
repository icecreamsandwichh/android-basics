package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val isAirplaneModeEnabled = intent.getBooleanExtra("state", false)
        if (isAirplaneModeEnabled) {
            Toast.makeText(context, "Aeroplane mode enabled...", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Aeroplane mode disabled...", Toast.LENGTH_SHORT).show()
        }
    }
}