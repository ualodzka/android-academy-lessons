package com.example.vova.androidacademylessons

import android.content.Intent
import android.net.Uri
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
            startWebIntent("https://www.instagram.com/spongebob/")
        }
        facebookImageView.setOnClickListener {
            startWebIntent("https://www.facebook.com/spongebob/")

        }
        sendMessageButton.setOnClickListener {
            //           val message = sendMessageEditText.text.toString()
//           val intent = Intent()
        }
    }

    private fun startWebIntent(url: String?) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }


}


