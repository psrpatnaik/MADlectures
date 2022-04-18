package com.example.button_tap_2

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat


class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var b = findViewById<Button>(R.id.button2);
        b.setOnClickListener(View.OnClickListener {
        /*
            // Explicit Intent, you need to associate an activity using FQN see the below line.
        var intent:Intent = Intent(this, Class.forName("com.example.button_tap_2.MainActivity"))
        // startActivity is used to invoke other activity associated to an Intent object.
            startActivity(intent)

         */
            if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                Log.i("Permission Check", "Yes")
                // call to dialer app to make call
                val callIntent = Intent().apply {
                    action = Intent.ACTION_CALL
                }
                callIntent.setData(Uri.parse("tel:+919876543210"))
                startActivity(callIntent)
            }else{
                Log.i("Permission Check", "No")
                Log.i("Permission Check", "Requesting Permission")
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),10)
            }

            /*



             */
        }
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 10){
            if(grantResults.isEmpty()){
                Log.i("Permission Check", "Missed the Permission Request")
            }
            if ((grantResults.isNotEmpty() &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // Permission is granted. Continue the action or workflow
                // in your app.
                val callIntent = Intent().apply {
                    action = Intent.ACTION_CALL
                }
                callIntent.setData(Uri.parse("tel:+919876543210"))
                startActivity(callIntent)
            }
            else{
                Toast.makeText(this,"You denied permission",Toast.LENGTH_LONG).show()
            }
        }

    }
}