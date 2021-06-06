package com.hzn.haylie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hzn.haylie.nested.NestedActivity
import com.hzn.haylie.fixed.FixedActivity
import com.hzn.haylie.listview.ListViewActivity
import com.hzn.haylie.recyclerview.RecyclerViewActivity
import com.hzn.haylie.viewpager.ViewPagerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnListView.setOnClickListener { startActivity(Intent(this, ListViewActivity::class.java)) }
        btnRecyclerView.setOnClickListener { startActivity(Intent(this, RecyclerViewActivity::class.java)) }
        btnViewPager.setOnClickListener { startActivity(Intent(this, ViewPagerActivity::class.java)) }
        btnFixed.setOnClickListener { startActivity(Intent(this, FixedActivity::class.java)) }
        btnAll.setOnClickListener { startActivity(Intent(this, NestedActivity::class.java)) }
    }
}
