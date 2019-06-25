package com.project.siva.recyclerview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_listing.*

class ListingFragment : Fragment(){

    private val dataList = mutableListOf<String>()
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        populateData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = Adapter(dataList)
        linearLayoutManager = LinearLayoutManager(activity)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = adapter
    }

    private fun populateData() {
        for (i in 1..20)
            dataList.add("Item No : $i")
    }
}
