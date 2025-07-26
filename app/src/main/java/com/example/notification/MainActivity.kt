package com.example.notification

import android.app.NotificationManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

lateinit var notificationManager:NotificationManager
lateinit var builder:NotificationCompat.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        notificationManager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager

    }
    fun btnclick(v:View){

       builder=NotificationCompat.Builder(this,"n_channel")
           .setContentTitle("just a title")
           .setContentText("just a body")
           .setLargeIcon(getmyBitmap(R.drawable.noti))
           .setSmallIcon(R.drawable.ic_stat_name)

    }

    private fun getmyBitmap(imgres: Int): Bitmap {
val drawable:Drawable? =ResourcesCompat.getDrawable(resources,imgres,null)
var drBitmap:BitmapDrawable=drawable as BitmapDrawable
        return drBitmap.bitmap
    }
}