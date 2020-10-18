package com.yml.tab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var vp:ViewPager
    private lateinit var tabL:TabLayout
    private lateinit var drawer: DrawerLayout
    private lateinit var nav:NavigationView
    private lateinit var toolBar: androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vp=findViewById(R.id.viewPager)
        tabL=findViewById(R.id.tabLayout)
        toolBar=findViewById(R.id.toolbar)
        toolBar.setTitle("Tab example")
        val fragmentPagerAdapter = PagerAdapter(supportFragmentManager)
        vp.adapter = fragmentPagerAdapter
        tabL.setupWithViewPager(vp)

    }

}