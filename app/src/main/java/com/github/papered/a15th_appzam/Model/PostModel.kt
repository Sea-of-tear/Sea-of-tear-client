package com.github.papered.a15th_appzam.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by PaperEd on 2018-04-01.
 */
@SuppressWarnings("serial")
class PostModel {

    @SerializedName("title")
    val title: String = ""

    @SerializedName("category")
    val category: String = ""

    @SerializedName("author")
    val author: String = ""

    @SerializedName("posting_time")
    val postingTime = ""

    @SerializedName("commentCount")
    val commentCount = 0

    @SerializedName("tearCount")
    val tearCount = 0
}