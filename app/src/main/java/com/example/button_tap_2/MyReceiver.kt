package com.example.button_tap_2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Toast.makeText(context,"AIR PLANE MODE ON/OFF", Toast.LENGTH_LONG).show()
        Log.i("Button_Tap_2","AIR PLANE MODE BROADCAST RECEIVED")
    }
}