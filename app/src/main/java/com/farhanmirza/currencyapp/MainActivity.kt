package com.farhanmirza.currencyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var ratesRecyclerView : RecyclerView
    lateinit var ratesList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ratesList = arrayListOf("Rate 1","Rate 2")

        ratesRecyclerView = findViewById(R.id.rates_list)
        ratesRecyclerView.layoutManager = LinearLayoutManager(this)
        ratesRecyclerView.setHasFixedSize(true)
        ratesRecyclerView.adapter = RatesAdapter(ratesList)

    }
}