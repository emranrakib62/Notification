package com.example.notification

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.google.firebase.messaging.FirebaseMessagingService

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MyService : FirebaseMessagingService() {

    override fun onNewToken(token:String){
super.onNewToken(token)
    }

}