package com.project.siva.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listingFragment = ListingFragment()
        supportFragmentManager.beginTransaction().add(R.id.container,listingFragment).commit()
    }
}
