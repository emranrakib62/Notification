package com.example.notification

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.media.session.MediaSession.Token
import android.os.IBinder
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MyService : FirebaseMessagingService() {

    override fun onNewToken(token:String){
super.onNewToken(token)
Log.d("TAG","onNewToken :$token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        var title=message.notification?.title
        var body=message.notification?.body
        super.onMessageReceived(message)
    }

}