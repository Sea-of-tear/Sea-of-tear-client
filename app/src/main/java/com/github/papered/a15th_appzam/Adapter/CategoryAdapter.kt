package com.github.papered.a15th_appzam.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.papered.a15th_appzam.R
import com.github.papered.a15th_appzam.R.id.parent

/**
 * Created by PaperEd on 2018-04-01.
 */
class CategoryAdapter(val context: Context, val data: ArrayList<String>) : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {
    private var itemClick: ItemClick? = null

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    //아이템 클릭시 실행 함수 등록 함수
    fun setItemClick(itemClick: ItemClick) {
        this.itemClick = itemClick
    }

    override fun onBindViewHolder(holder: CategoryHolder?, position: Int) {
        Log.d("CategoryAdapter: ", data.toString())
        holder?.bind(data[position], context)
        holder!!.itemView.setOnClickListener {
            itemClick!!.onClick(holder.itemView, position)
        }

        when(position){

        }
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false)
        return CategoryHolder(view)
    }

    inner class CategoryHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val name = itemView?.findViewById<TextView>(R.id.categoryItem_text)

        fun bind(text: String, context: Context) {
            name!!.text = text
        }
    }
}