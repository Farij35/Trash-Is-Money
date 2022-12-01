package com.capstone.trashismoney.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.trashismoney.R
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class ListItemAdapter(private val itemList: ArrayList<Item>) :
    RecyclerView.Adapter<ListItemAdapter.MyItemHolder>(){

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class MyItemHolder(ItemView: View, listener: onItemClickListener):RecyclerView.ViewHolder(ItemView){
        val Name: TextView = itemView.findViewById(R.id.tv_item_name)
        val Price: TextView = itemView.findViewById(R.id.tv_item_price)
        val Img: ImageView = itemView.findViewById(R.id.img_item_photo)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyItemHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyItemHolder, position: Int){

        holder.Name.text = itemList[position].name
        holder.Price.text = NumberFormat.getCurrencyInstance(Locale("IND", "ID")).format(itemList[position].price)
        Glide.with(holder.itemView.context).load(itemList[position].image).into(holder.Img)


    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}

