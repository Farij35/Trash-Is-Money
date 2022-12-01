package com.capstone.trashismoney.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.trashismoney.ItemDetail
import com.capstone.trashismoney.R
import com.capstone.trashismoney.fragments.adapter.Item
import com.capstone.trashismoney.fragments.adapter.ListItemAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemList: ArrayList<Item>
    private var db = Firebase.firestore
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.item_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        itemList = arrayListOf()

        db = FirebaseFirestore.getInstance()
        db.collection("item_list").get()
            .addOnSuccessListener {
                if (!it.isEmpty){
                    for (data in it.documents){
                        val item: Item? = data.toObject(Item::class.java)
                        if (item != null) {
                            itemList.add(item)
                        }
                    }
                    var adapter = ListItemAdapter(itemList)
                    recyclerView.adapter = adapter
                    adapter.setOnItemClickListener(object : ListItemAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(activity, ItemDetail::class.java)
                            intent.putExtra(ItemDetail.ITEM_DETAIL, itemList)
                            startActivity(intent)
                        }
                    })
                }
            }
            .addOnFailureListener {
                Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}