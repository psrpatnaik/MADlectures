package com.example.button_tap_2

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // var var_name:String? = "Hello"
    // null safety in Kotlin
    // String str = null;
    //var count:Int = 0;
     lateinit var mtv:EditText
     lateinit var tv:TextView
     var count:Int = 0;
     var countBkp:Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b = findViewById<Button>(R.id.button);
        tv = findViewById<TextView>(R.id.textView);
        mtv = findViewById<EditText>(R.id.editTextTextMultiLine)
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        count = sharedPref.getInt("countValue",-1)
        if (count == -1){
            count = 0
            Log.i("Button_Tap_2","No count value in SharedPreference")
        }

        b.setOnClickListener(View.OnClickListener {
            count = count + 1
            tv.text="Clicked ${count} times"
        //Intent (Implicit)
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Sample text to be shared")
                type = "text/plain"
            }
        // Try to invoke the intent.
            try {
                startActivity(sendIntent)
            } catch (e: ActivityNotFoundException) {
                // Define what your app should do if no activity can handle the intent.
            }
        })

        //mtv.append("OnCreate\n")
        Log.i("Button_Tap_2","onCreate")
        if (savedInstanceState != null){
            count = savedInstanceState.getInt("countValue")
            tv.text="Clicked ${count} times"
        }
        else{
            mtv.append("#OnCreate\n")
        }


        //


    }

    override fun onStart() {
        super.onStart()
        mtv.append("OnStart\n")
        Log.i("Button_Tap_2","onStart")
    }

    override fun onStop() {
        super.onStop()
        mtv.append("OnStop\n")
        Log.i("Button_Tap_2","onStop")
    }

    override fun onResume() {
        super.onResume()
        mtv.append("OnResume\n")
        Log.i("Button_Tap_2","onResume")
    }

    override fun onRestart() {
        super.onRestart()
        mtv.append("OnRestart\n")
        Log.i("Button_Tap_2","onRestart")
    }

    override fun onPause() {
        super.onPause()
        mtv.append("OnPause\n")
        countBkp = count
        mtv.append("coutnBkp ${countBkp}\n")
        Log.i("Button_Tap_2","onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        mtv.append("OnDestroy\n")
        Log.i("Button_Tap_2","onDestroy")
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        /*
        with (sharedPref.edit()) {
            putInt(getString(R.string.saved_high_score_key), newHighScore)
            apply()
        }
         */
        var editor = sharedPref.edit()
        editor.putInt("countValue",count)
        editor.apply()
    }

    // API 21 , 22,
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        mtv.append("Saved")

        Log.i("Button_Tap_2","onSaveInstanceState Two Arg")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("Button_Tap_2","value of count variable is ${count}")
        outState.putInt("countValue",count)
        Log.i("Button_Tap_2","onSaveInstanceState One Arg")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("Button_Tap_2","onRestoreInstanceState")
        mtv.append("Restored\n")
        count = savedInstanceState.getInt("countValue")
        Log.i("Button_Tap_2","value of count variable restored is ${count}")
        tv.text="Clicked ${count} times"


    }
}
