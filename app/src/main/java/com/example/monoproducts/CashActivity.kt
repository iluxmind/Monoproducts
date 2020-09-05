package com.example.monoproducts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monoproduct.adapter.CashAdapter
import com.example.monoproduct.adapter.ProductAdapter
import com.example.monoproducts.Model.Shopping
import com.example.monoproducts.ui.home.HomeViewModel
import com.google.gson.Gson

class CashActivity : AppCompatActivity() {
    private lateinit var homeViewModel: HomeViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash)

        val gson = Gson()
        var  obj = intent.getStringExtra("data")
        val data: Shopping = gson.fromJson(obj, Shopping::class.java)

        val cash = ArrayList<String>()
        cash.add("ชำระผ่าน ATM")
        cash.add("ชำระเงินปลายทาง")
        recyclerView = findViewById(R.id.cash)
        viewManager = LinearLayoutManager(this)
        viewAdapter = CashAdapter(data,cash,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.adapter = viewAdapter
    }
}