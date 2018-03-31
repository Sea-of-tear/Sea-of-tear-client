package com.github.papered.a15th_appzam.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.papered.a15th_appzam.Connect.Connector
import com.github.papered.a15th_appzam.R
import com.github.papered.a15th_appzam.R.id.login_edit_id
import com.github.papered.a15th_appzam.R.id.login_edit_pw
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


//        Connector.api.auth(login_edit_id.text.toString(), login_edit_pw.text.toString()).enqueue(object : Callback<Void> {
//            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
//                if (response!!.isSuccessful) {
//                    when (response.code()) {
//
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<Void>?, t: Throwable?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//        })

        login_btn_submit.setOnClickListener {
            startActivity(Intent(this, SetProfileActivity::class.java))
//            Connector.api.auth(login_edit_id.text.toString(), login_edit_pw.text.toString()).enqueue(object : Callback<Void> {
//                override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
//                    if (response!!.isSuccessful) {
//                        when (response.code()) {
//
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<Void>?, t: Throwable?) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }

        }
    }

}
