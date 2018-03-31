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

    @GET("/my-page")
    fun getProfile(@Header("Authorization") Authorization: String) : Call<Void>

    @POST("/post-eye")
    @FormUrlEncoded
    fun postEye(@Header("Authorization") Authorization: String, @Field("title") title: String, @Field("description") description: String, @Field("background") background: Int, @Field("category") category: Int): Call<Void>

    @GET("/eye-list")
    fun getPostList(@Header("Authorization") Authorization: String, @Query("category") category: Int): Call<PostModel>

    @GET("/eye/{id}")
    fun getDetail(@Header("Authorization")Authorization: String,@Path(encoded = true, value = "id")id:String) : Call<Void>
}