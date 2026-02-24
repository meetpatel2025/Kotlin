package com.training.libraryofalltopics.viewpager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.training.libraryofalltopics.R

class ViewPagerMainActivity : AppCompatActivity() {

    lateinit var viewPager2 : ViewPager2
    lateinit var myAdapter : ViewPagerMyPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.view_pager_activity_main)
        viewPager2 = findViewById(R.id.viewPager2)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        myAdapter = ViewPagerMyPagerAdapter(supportFragmentManager, lifecycle)
        myAdapter.addFragments(ViewPagerFragmentOne())
        myAdapter.addFragments(ViewPagerFragmentTwo())
        myAdapter.addFragments(ViewPagerFragmentThree())

        viewPager2.adapter = myAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}