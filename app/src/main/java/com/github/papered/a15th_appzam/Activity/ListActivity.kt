package com.github.papered.a15th_appzam.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.papered.a15th_appzam.Adapter.PostAdapter
import com.github.papered.a15th_appzam.Connect.Connector
import com.github.papered.a15th_appzam.Model.PostModel
import com.github.papered.a15th_appzam.R
import com.github.papered.a15th_appzam.Util
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val intent = intent
        var model: PostModel
        var adapter: PostAdapter
        Connector.api.getPostList(Util.getToken(baseContext), intent.getIntExtra("position", 0))
                .enqueue(object : Callback<PostModel> {
                    override fun onResponse(call: Call<PostModel>?, response: Response<PostModel>?) {
                        val res = response!!.body()
                        model = res!!
                        adapter = PostAdapter(baseContext, listOf(model) as ArrayList<PostModel>)
                        list_post.adapter = adapter
                        adapter.notifyDataSetChanged()
                        adapter.setItemClick(object : PostAdapter.ItemClick {
                            override fun onClick(view: View, position: Int) {
                                Connector.api.getDetail(Util.getToken(baseContext),"5ac0055b4a7af308ba355535")
                                        .enqueue(object : Callback<Void> {
                                            override fun onFailure(call: Call<Void>?, t: Throwable?) {

                                            }

                                            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {

                                            }

                                        })
                            }

                        })

                    }

                    override fun onFailure(call: Call<PostModel>?, t: Throwable?) {

                    }

                })
    }
}
