package com.example.coroutine

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch

class  MainActivity : AppCompatActivity() {

    val TAG = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textView = findViewById<TextView>(R.id.textView)

    }

    //fun main() {
    //    println("Main program starts: ${Thread.currentThread().name}")

    //    GlobalScope.launch {
    //        println("Fake work starts: ${Thread.currentThread().name}")
    //        Thread.sleep(1000)
    //        println("Fake work finished: ${Thread.currentThread().name}")
    //    }

    //    Thread.sleep(2000)
    //    println("Main program ends: ${Thread.currentThread().name}")
    //}

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
                Log.i(TAG, "run: Download finished")
               // Toast.makeText(this, "Download finished", Toast.LENGTH_SHORT).show();
            }
        }
    }


