package com.github.papered.a15th_appzam.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.papered.a15th_appzam.Connect.Connector
import com.github.papered.a15th_appzam.Model.Jwt
import com.github.papered.a15th_appzam.R
import com.github.papered.a15th_appzam.R.id.login_edit_id
import com.github.papered.a15th_appzam.R.id.login_edit_pw
import com.github.papered.a15th_appzam.Util
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn_submit.setOnClickListener {
            Connector.api.auth(login_edit_id.text.toString(), login_edit_pw.text.toString()).enqueue(object : Callback<Jwt> {
                override fun onResponse(call: Call<Jwt>?, response: Response<Jwt>?) {
                    if (response!!.isSuccessful) {
                        val res = response.body()
                        Toast.makeText(baseContext, res!!.token, Toast.LENGTH_SHORT).show()

                        Util.saveToken("JWT " + res.token, baseContext)
                    }
                    startActivity(Intent(baseContext, SetProfileActivity::class.java))
                }

                override fun onFailure(call: Call<Jwt>?, t: Throwable?) {
                    Toast.makeText(baseContext, "안되냐고", Toast.LENGTH_SHORT).show()
                }

            })
        }
        login_text_auth.setOnClickListener {
            startActivity(Intent(this, JoinActivity::class.java))
        }
    }
}
