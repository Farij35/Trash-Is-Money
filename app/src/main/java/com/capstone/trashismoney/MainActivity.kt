package com.capstone.trashismoney

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.capstone.trashismoney.fragments.HomeFragment
import com.capstone.trashismoney.fragments.SecondFragment
import com.capstone.trashismoney.fragments.adapter.Item
import com.capstone.trashismoney.fragments.adapter.ListItemAdapter
import com.capstone.trashismoney.fragments.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpToolbar()
        setUpTabs()
    }

    private fun setUpToolbar() {
        val toolbars = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbars)

        supportActionBar?.apply {
            title = "Marketplace"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
        }
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabs = findViewById<TabLayout>(R.id.tabs)
        adapter.addFragment(HomeFragment(), "Organik")
        adapter.addFragment(SecondFragment(), "Anorganik")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}