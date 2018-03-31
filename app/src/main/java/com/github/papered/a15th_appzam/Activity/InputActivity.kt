package com.github.papered.a15th_appzam.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.github.papered.a15th_appzam.Connect.Connector
import com.github.papered.a15th_appzam.R
import com.github.papered.a15th_appzam.Util
import kotlinx.android.synthetic.main.activity_input.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        val spinnerAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listOf("연애", "취업-진로", "인간관계", "반려동물", "기타"))
        var genre = ""
        input_spinner.adapter = spinnerAdapter

        input_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                genre = input_spinner.getItemAtPosition(p2).toString()
            }

        }
        var imgIndex = 0
        input_image_left.setOnClickListener {
            if (imgIndex == 0) {
                imgIndex = 10
            } else {
                imgIndex--
            }
        }
        input_image_right.setOnClickListener {
            if (imgIndex == 10) {
                imgIndex = 0
            } else {
                imgIndex++
            }
        }
        input_text_submit.setOnClickListener {
            Connector.api.postEye(Util.getToken(baseContext), input_edit_text.text.toString(), input_edit_content.text.toString(), imgIndex, genre)
                    .enqueue(object : Callback<Void> {
                        override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                            Toast.makeText(baseContext, "된다", Toast.LENGTH_SHORT).show()
                        }

                        override fun onFailure(call: Call<Void>?, t: Throwable?) {

                        }

                    })
        }

    }
}
