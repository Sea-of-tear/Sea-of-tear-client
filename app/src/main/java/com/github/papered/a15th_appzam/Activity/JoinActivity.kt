package com.github.papered.a15th_appzam.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.papered.a15th_appzam.Connect.Connector
import com.github.papered.a15th_appzam.R
import com.github.papered.a15th_appzam.Util
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
                Connector.api.signIn(
                        join_edit_id.text.toString(),
                        join_edit_pw.text.toString(),
                        join_edit_email.text.toString()).enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                        Toast.makeText(baseContext, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
//                        startActivity(Intent(baseContext,SetProfileActivity::class.java))
                        finish()
                    }

                    override fun onFailure(call: Call<Void>?, t: Throwable?) {
                    }

                })
            }
        }
    }
}
