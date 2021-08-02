package com.example.service

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.start_btn)
        val btnStop = findViewById<Button>(R.id.stop_btn)
        val btnSend = findViewById<Button>(R.id.send_data)
        val statusTextView = findViewById<TextView>(R.id.status)
        val dataEditText = findViewById<EditText>(R.id.data_text_field)


        btnStart.setOnClickListener {
            Intent (this,MyService::class.java).also {
                startService(it)
                statusTextView.text = "Service Running..."
            }
        }
        btnStop.setOnClickListener {
            Intent (this,MyService::class.java).also {
                stopService(it)
                statusTextView.text = "Service Stopped"
            }
        }
        btnSend.setOnClickListener {
            val text = dataEditText.text.toString()
            Intent (this,MyService::class.java).also {
                it.putExtra(Constants.DATA_STRING,text)
                startService(it)
            }

        }
    }
}