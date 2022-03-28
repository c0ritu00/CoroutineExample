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
import kotlinx.coroutines.GlobalScope
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
        var textView2 = findViewById<TextView>(R.id.textView2)
        textView2.text = "Thread is running";
        runnable(textView2)
    }

    fun runnable(textView2: TextView) {
            GlobalScope.launch {
                    try {
                        Thread.sleep(5000)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                Handler(Looper.getMainLooper()).postAtTime({
                    Toast.makeText(this@MainActivity, "Download finished", Toast.LENGTH_SHORT).show();
                    textView2.text = "Press Button to Start"
                },1000)
            }
        }
    }


