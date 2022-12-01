package com.capstone.trashismoney

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import com.bumptech.glide.Glide
import com.capstone.trashismoney.fragments.adapter.Item
import java.text.NumberFormat
import java.util.*

class ItemDetail : AppCompatActivity() {

    companion object{
        const val ITEM_DETAIL = "item_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail)

        val img: ImageView = findViewById(R.id.img_detail)
        val name: TextView = findViewById(R.id.nama_barang)
        val harga: TextView = findViewById(R.id.harga_barang)

        val item = intent.getParcelableExtra<Item>(ITEM_DETAIL) as? Item
//        Glide.with(this).load(item.image).into(img)
//        name.text = item.name
        Log.d("Nama Item", item?.name.toString())
//        harga.text = item.price.toString()
    }
}