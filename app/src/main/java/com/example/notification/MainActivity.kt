package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

lateinit var notificationManager:NotificationManager
lateinit var builder:NotificationCompat.Builder
lateinit var btnnotif:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        notificationManager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
          btnnotif=findViewById(R.id.btnnotif)

        btnnotif.setOnClickListener {

            val intent=Intent(this,MainActivity2::class.java)
            intent.putExtra("key","From Notification")

            val pendingIntent=PendingIntent.getActivity(applicationContext,101,intent ,PendingIntent.FLAG_UPDATE_CURRENT)

            builder=NotificationCompat.Builder(this,"n_channel")
                .setContentTitle("just a title")
                .setContentText("just a body")
                .setLargeIcon(getmyBitmap(R.drawable.noti))
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentIntent(pendingIntent)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(NotificationChannel("n_channel","",NotificationManager.IMPORTANCE_HIGH))
            }
            val id=System.currentTimeMillis().toInt()

            notificationManager.notify(id,builder.build())



        }



    }




    fun btnclick(v:View){


    }

    private fun getmyBitmap(imgres: Int): Bitmap {
val drawable:Drawable? =ResourcesCompat.getDrawable(resources,imgres,null)
var drBitmap:BitmapDrawable=drawable as BitmapDrawable
        return drBitmap.bitmap
    }
}