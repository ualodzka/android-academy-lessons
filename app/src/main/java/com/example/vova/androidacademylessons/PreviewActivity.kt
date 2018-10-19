package com.example.vova.androidacademylessons

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_preview.*
import android.content.ActivityNotFoundException
import android.widget.Toast


const val KEY_MESSAGE = "KEY_MESSAGE"

class PreviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        setListeners()
        showMessage()
    }

    private fun showMessage() {
        val message = intent.extras?.getString(KEY_MESSAGE)
        previewTextView.text = message
    }

    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SEND)

        with(intent) {
            type = "text/html"
            putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.preview_android_academy_email_address)))
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.preview_hello_android_academy))
            putExtra(Intent.EXTRA_TEXT, previewTextView.text)
        }

        try {
            startActivity(Intent.createChooser(intent, getString(R.string.preview_send_email)))
        } catch (e: ActivityNotFoundException) {
            Toast
                    .makeText(this, getString(R.string.errors_no_email_app), Toast.LENGTH_LONG)
                    .show()
        }
    }

    private fun setListeners() {
        emailButton.setOnClickListener { sendEmail() }
    }

    companion object {
        fun start(activity: Activity, message: String) {
            val intent = Intent(activity, PreviewActivity::class.java)
            intent.putExtra(KEY_MESSAGE, message)
            activity.startActivity(intent)
        }
    }

}