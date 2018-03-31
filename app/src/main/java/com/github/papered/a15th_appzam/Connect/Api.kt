package com.github.papered.a15th_appzam.Connect

import com.github.papered.a15th_appzam.Model.Jwt
import com.github.papered.a15th_appzam.Model.PostModel
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
    fun setProfile(@Header("Authorization") Authorization: String, @Field("nickname") nickname: String, @Field("introduction") description: String): Call<Void>

    @POST("/post-eye")
    @FormUrlEncoded
    fun postEye(@Header("Authorization") Authorization: String, @Field("title") title: String, @Field("description") description: String, @Field("background") background: Int, @Field("category") category: Int): Call<Void>

    @GET("/eye/{category}")
    fun getPostList(@Path(value = "category", encoded = true) category: Int): Call<PostModel>
}