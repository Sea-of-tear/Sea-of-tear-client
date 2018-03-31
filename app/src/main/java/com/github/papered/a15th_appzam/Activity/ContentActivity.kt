package com.github.papered.a15th_appzam.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.papered.a15th_appzam.R
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.activity_content.view.*

class ContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        send_btn.setOnClickListener {
            imageView3.visibility = View.VISIBLE
            textView1.visibility = View.VISIBLE
            textView1.text = comment_content.text.toString()
        }
        content_image.setOnClickListener {
            tears.text = (tears.text.toString().toInt() + 1).toString()
        }
    }
}
