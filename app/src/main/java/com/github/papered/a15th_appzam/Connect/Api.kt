package com.github.papered.a15th_appzam.Connect

import com.github.papered.a15th_appzam.Model.Jwt
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by PaperEd on 2018-03-31.
 */
interface Api {
    @POST("/login")
    @FormUrlEncoded
    fun auth(@Field("id") id: String, @Field("pw") pw: String): Call<Jwt>

    @POST("/signup")
    @FormUrlEncoded
    fun signIn(@Field("id") id: String, @Field("pw") pw: String, @Field("email") email: String): Call<Void>

    @POST("/my-page")
    @FormUrlEncoded
    fun setProfile(@Header("Authorization") jwt: String, @Field("nickname") nickname: String, @Field("introduction") description: String): Call<Void>


}