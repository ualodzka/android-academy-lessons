package com.example.vova.androidacademylessons

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

   private fun setListeners() {
       instagramImageView.setOnClickListener {
           //launch instagram in browser
       }
       facebookImageView.setOnClickListener {
           //launch facebook
       }
       sendMessageButton.setOnClickListener {
//           val message = sendMessageEditText.text.toString()
//           val intent = Intent()
       }
    }



}


