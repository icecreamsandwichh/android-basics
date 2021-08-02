package com.example.simplenotification

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder
import com.example.simplenotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        
        val intent  = Intent(this,MainActivity::class.java)
        // By this method we maintain the backstack from which notification was sent
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT)
        }
        val notificationManager = NotificationManagerCompat.from(this)

        binding.button.setOnClickListener {
            val title = binding.title.text.toString()
            val desc = binding.desc.text.toString()
            val notificationBuilder = NotificationCompat.Builder(this,Constants.CHANNEL_ID).apply {
                setSmallIcon(R.drawable.ic_launcher_foreground)
                priority = NotificationCompat.PRIORITY_HIGH
                setContentText(desc)
                setContentTitle(title)
                setContentIntent(pendingIntent)
            }
            notificationManager.notify(Constants.NOTIFICATION_ID,notificationBuilder.build())
        }

    }
}