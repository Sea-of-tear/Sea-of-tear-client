package com.github.papered.a15th_appzam.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.github.papered.a15th_appzam.Adapter.CategoryAdapter
import com.github.papered.a15th_appzam.Connect.Connector
import com.github.papered.a15th_appzam.Model.PostModel
import com.github.papered.a15th_appzam.R
import com.github.papered.a15th_appzam.R.id.main_categoryView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapterlistItem = arrayListOf("연애", "취업-진로", "인간관계", "반려동물", "기타")
        val adapter = CategoryAdapter(baseContext, adapterlistItem)
        adapter.setItemClick(object : CategoryAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext, adapterlistItem[position], Toast.LENGTH_SHORT).show()
                Connector.api.getPostList(position).enqueue(object : Callback<PostModel> {
                    override fun onResponse(call: Call<PostModel>?, response: Response<PostModel>?) {
//                        val intent = Intent(this,)
                    }

                    override fun onFailure(call: Call<PostModel>?, t: Throwable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })
            }
        })
        Toast.makeText(baseContext, adapterlistItem.size.toString(), Toast.LENGTH_SHORT).show()
        main_categoryView.layoutManager = layoutManager
        main_categoryView.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
