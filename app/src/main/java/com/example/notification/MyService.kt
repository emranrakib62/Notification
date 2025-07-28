package com.example.notification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.session.MediaSession.Token
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MyService : FirebaseMessagingService() {

    override fun onNewToken(token:String){
super.onNewToken(token)
Log.d("TAG","onNewToken :$token")
    }



    private lateinit var notificationManager: NotificationManager
    private lateinit var builder: NotificationCompat.Builder
    private val channelId = "1.apps.notifications"
    private val description = "Test notification"


    override fun onMessageReceived(message: RemoteMessage) {
        var title=message.notification?.title
        var body=message.notification?.body

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        super.onMessageReceived(message)
    }

    private fun showNotification(title:String,body:String) {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_MUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId, description, NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_stat_name)
            .setContentTitle("Title")
            .setContentText("This is a test notification.")
            .setAutoCancel(true)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    this.resources,
                    R.drawable.noti
                )
            )
            .setContentIntent(pendingIntent)

        val id = System.currentTimeMillis().toInt()
        notificationManager.notify(id, builder.build())
    }

}