package com.github.papered.a15th_appzam.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.papered.a15th_appzam.Model.PostModel
import com.github.papered.a15th_appzam.R

/**
 * Created by PaperEd on 2018-04-01.
 */
class PostAdapter(val context: Context, val data: ArrayList<PostModel>) : RecyclerView.Adapter<PostAdapter.PostHolder>() {

    private var itemClick: ItemClick? = null

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    //아이템 클릭시 실행 함수 등록 함수
    fun setItemClick(itemClick: ItemClick) {
        this.itemClick = itemClick
    }

    override fun onBindViewHolder(holder: PostAdapter.PostHolder?, position: Int) {
        Log.d("CategoryAdapter: ", data.toString())
        holder?.bind(data[position], context)
        holder!!.itemView.setOnClickListener {
            itemClick!!.onClick(holder.itemView, position)
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostAdapter.PostHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.post_list_item, parent, false)
        return PostHolder(view)
    }

    inner class PostHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val title = itemView?.findViewById<TextView>(R.id.post_text_title)
        val date = itemView?.findViewById<TextView>(R.id.post_text_date)
        val user = itemView?.findViewById<TextView>(R.id.post_text_user)
        val tearCount = itemView?.findViewById<TextView>(R.id.post_text_tearCount)
        fun bind(postModel: PostModel, context: Context) {
            title!!.text = postModel.title
            date!!.text = postModel.postingTime
            user!!.text = postModel.author
            tearCount!!.text = postModel.tearCount.toString()
        }
    }
}