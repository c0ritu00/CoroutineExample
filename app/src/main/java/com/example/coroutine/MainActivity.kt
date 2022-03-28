package com.example.coroutine

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch

class  MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textView = findViewById<TextView>(R.id.textView)
        var switch = findViewById<Switch>(R.id.switch1)

        switch.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "Switch:ON" else "Switch:OFF"
            textView.text = message
        }
    }

    fun buttonClicked(view: View){
        runnable()
    }

    fun runnable() {

        @OptIn(InternalCoroutinesApi::class)

            GlobalScope.launch {
                synchronized(this) {
                    try {
                        Thread.sleep(5000)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                Handler(Looper.getMainLooper()).postAtTime({
                    Toast.makeText(this@MainActivity, "Download finished", Toast.LENGTH_SHORT).show();
                },1000)
                Log.i(TAG, "run: Download finished")
            }
        }
    }


