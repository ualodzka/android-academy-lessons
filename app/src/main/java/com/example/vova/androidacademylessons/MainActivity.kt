package com.example.vova.androidacademylessons

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        previewButton.setOnClickListener {
            PreviewActivity.start(this, typeYourMessageEditText.text.toString())
        }
    }
}
