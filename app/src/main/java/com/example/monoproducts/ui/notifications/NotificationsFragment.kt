package com.example.monoproducts.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.monoproducts.Model.Shopping
import com.example.monoproducts.R
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        var text:String
        val fileName = "history.json"

        requireContext().openFileInput(fileName).use { stream ->
            text = stream.bufferedReader().use {
                it.readText()
            }

            Log.d("ddddddddddUser",text)
            val gson = Gson()
            val data: Shopping = gson.fromJson(text, Shopping::class.java)
            val prices: Double = data.product!!.productPrice.toDouble() * data.unit!!.toDouble()

            root.shipprice.text = root.shippingprice.text
            val total: Double = prices + root.shipprice.text.toString().toDouble()
            if(data.address.fullname.isEmpty()){

            }else{
                root.address.text = data.address.fullname + " | " + data.address.tel + "\n" + data.address.detail +" อำเภอ"+ data.address.district+", จังหวัด"+data.address.province+","+data.address.zipcode
            }
            root.nameproduct.text = data.product!!.productName
            root.priceproduct.text = "฿"+data.product!!.productPrice.toString()
            root.unitproduct.text = "X"+ data.unit
            root.price.text = prices.toString()
            root.total1.text = total.toString()
            root.cash.text = data.cash
            val imageUrl = data.product!!.productImg.toString()
            Picasso.get().load(imageUrl).into(root.imagepd)
        }
        return root
    }
}