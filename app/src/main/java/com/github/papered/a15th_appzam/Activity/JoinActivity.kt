package com.github.papered.a15th_appzam.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.papered.a15th_appzam.Connect.Connector
import com.github.papered.a15th_appzam.R
import kotlinx.android.synthetic.main.activity_join.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
        join_btn_submit.setOnClickListener {
            if (join_edit_pw.text.toString() == join_edit_confirm.text.toString()) {
                Connector.api.signIn(join_edit_id.text.toString(),
                        join_edit_pw.text.toString(),
                        join_edit_email.text.toString()).enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onFailure(call: Call<Void>?, t: Throwable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }
        }
    }
}
