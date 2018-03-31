package com.github.papered.a15th_appzam.Connect

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by PaperEd on 2018-03-31.
 */
object Connector {
    lateinit var api : Api
    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("url will here")
                .build()

        api = retrofit.create(Api::class.java)
    }


}