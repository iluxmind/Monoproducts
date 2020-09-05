package com.example.monoproduct.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.monoproduct.Model.Product
import com.example.monoproducts.DetailActivity
import com.example.monoproducts.Model.Address
import com.example.monoproducts.Model.Shopping
import com.example.monoproducts.R
import com.example.monoproducts.ShippingActivity
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_cash.view.*
import kotlinx.android.synthetic.main.cash_list.view.*
import kotlinx.android.synthetic.main.product_list.view.*
import com.example.monoproduct.adapter.ViewHolders as ViewHolders

var shopping : Shopping = TODO()

class CashAdapter(val data : Shopping , val items : ArrayList<String>, val context: Context) : RecyclerView.Adapter<ViewHolders>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolders {
        return ViewHolders(LayoutInflater.from(context).inflate(R.layout.cash_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolders, position: Int) {
        holder?.name?.text = items.get(position)!!
        holder?.list.setOnClickListener{
            passData(items.get(position))
        }
    }
    private fun passData(cash:String) {
        var shopping : Shopping = Shopping(data.product, data.address, cash,data.unit)
        val intent = Intent(context, ShippingActivity::class.java)
        val gson = Gson()
        intent.putExtra("data", gson.toJson(shopping))
        context.startActivity(intent)
    }
}

class ViewHolders (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val name = view.name
    val list = view.list

}

