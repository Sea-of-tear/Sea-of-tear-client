package com.github.papered.a15th_appzam

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.widget.Toast

/**
 * Created by PaperEd on 2018-04-01.
 */
object Util {
    var token = ""
    fun saveToken(token: String, context: Context) {
        this.token = token
        val pref: SharedPreferences = context.getSharedPreferences("pref", MODE_PRIVATE);
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putString("token", token)
        editor.commit()
    }

    fun getToken(context: Context): String {
        val pref: SharedPreferences = context.getSharedPreferences("pref", MODE_PRIVATE)
        Toast.makeText(context, pref.getString("token", ""), Toast.LENGTH_SHORT).show()
        return pref.getString("token", "")
    }

}