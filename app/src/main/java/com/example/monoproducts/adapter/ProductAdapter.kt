package com.example.monoproduct.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.monoproduct.Model.Product
import com.example.monoproducts.DetailActivity
import com.example.monoproducts.R
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_list.view.*


class ProductAdapter(val items : ArrayList<Product?>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.product_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.name?.text = items.get(position)!!.productName.toString()
        holder?.price?.text = "฿ "+items.get(position)!!.productPrice.toString()
        val imageUrl = items.get(position)!!.productImg.toString()
        Picasso.get().load(imageUrl).into(holder?.img)
        holder?.product.setOnClickListener{
            passData(items.get(position))
        }
    }
    private fun passData(pd: Product?) {
        val intent = Intent(context, DetailActivity::class.java)
        val gson = Gson()
        intent.putExtra("data", gson.toJson(pd))
        context.startActivity(intent)
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val name = view.Productname
    val price = view.priceView
    val img = view.imageView
    val product = view.product

}

