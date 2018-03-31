package com.github.papered.a15th_appzam.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.papered.a15th_appzam.Connect.Connector
import com.github.papered.a15th_appzam.R
import com.github.papered.a15th_appzam.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        Connector.api.getProfile(Util.getToken(baseContext)).enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {

            }

        })
    }
}
