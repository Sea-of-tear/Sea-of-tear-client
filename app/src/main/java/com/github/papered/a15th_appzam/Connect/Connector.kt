package com.github.papered.a15th_appzam.Connect

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by PaperEd on 2018-03-31.
 */
object Connector {
    var api : Api
    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://52.79.60.204:80")
                .build()

        api = retrofit.create(Api::class.java)
    }


}