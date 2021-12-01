package com.example.week04day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private var tablayout:TabLayout?= null
    private var viewpager:ViewPager2?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
        prepareTabs()
    }

    private fun connectViews(){
        tablayout = findViewById(R.id.tabLayoutView)
        viewpager = findViewById(R.id.viewPagerView)
    }
    private fun prepareTabs(){
        val fAdapter:FragmentAdapter = FragmentAdapter(supportFragmentManager,lifecycle)
        fAdapter.addFragment(FirstFragment(),"Tab 1")
        fAdapter.addFragment(SecondFragment(),"Tab 2")

        viewpager?.adapter = fAdapter

        TabLayoutMediator(tablayout!!,viewpager!!){ tab,position ->
            tab.text = fAdapter.fragmentTitles[position]
        }.attach()
    }
}