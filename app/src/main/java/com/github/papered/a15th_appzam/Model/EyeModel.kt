package com.github.papered.a15th_appzam.Model

import com.google.gson.annotations.SerializedName

/**
 * Created by PaperEd on 2018-04-01.
 */
class EyeModel {
    var title = ""

    var description = ""

    var author=""

    var category=""

    @SerializedName("comments")
    var comments = arrayListOf<Comment>()

    inner class Comment{
        @SerializedName("author")
        var author=""

        @SerializedName("description")
        var description=""

        @SerializedName("tissue")
        var tissue = ""
    }
}