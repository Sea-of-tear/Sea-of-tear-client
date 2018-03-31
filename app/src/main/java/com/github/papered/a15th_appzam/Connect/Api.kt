package com.github.papered.a15th_appzam.Connect

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

/**
 * Created by PaperEd on 2018-03-31.
 */
interface Api {
    @POST("auth")
    fun auth(@Field("id") id: String, @Field("pw") pw: String) : Call<Void>
    fun signIn(@Field("id") id:String, @Field("pw") pw: String, @Field("email") email:String) : Call<Void>
}