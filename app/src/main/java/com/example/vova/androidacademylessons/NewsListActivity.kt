package com.example.vova.androidacademylessons

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class NewsListActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

    }

    public override fun onStart() {
        super.onStart()
        Thread(LeftLeg()).start()
        Thread(RightLeg()).start()
    }

    private inner class LeftLeg : Runnable {
        private val isRunning = true
        override fun run() {
            while (isRunning) Log.i("DEBUGZ", "Left step")
        }
    }

    private inner class RightLeg : Runnable {
        private val isRunning = true
        override fun run() {
            while (isRunning) Log.i("DEBUGZ", "Right step")
        }
    }

}