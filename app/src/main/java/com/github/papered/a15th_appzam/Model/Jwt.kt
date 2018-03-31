package com.github.papered.a15th_appzam.Model

import com.google.gson.annotations.SerializedName

/**
 * Created by PaperEd on 2018-04-01.
 */
class Jwt {
    @SerializedName("access_token")
    var token: String = ""
}