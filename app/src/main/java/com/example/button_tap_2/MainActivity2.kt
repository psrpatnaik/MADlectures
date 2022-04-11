package com.example.button_tap_2

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var b = findViewById<Button>(R.id.button2);
        b.setOnClickListener(View.OnClickListener {
        // Explicit Intent, you need to associate an activity using FQN see the below line.
       var intent:Intent = Intent(this, Class.forName("com.example.button_tap_2.MainActivity"))
        // startActivity is used to invoke other activity associated to an Intent object.
            startActivity(intent)
        })
    }
}