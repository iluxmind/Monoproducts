package com.example.monoproducts

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.monoproduct.Model.Product
import com.example.monoproducts.Model.Address
import com.example.monoproducts.Model.Shopping
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import java.lang.Exception


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val gson = Gson()
        val obj = intent.getStringExtra("data")
        val data: Product = gson.fromJson(obj, Product::class.java)

        val imageUrl = data.productImg.toString()
        Picasso.get().load(imageUrl).into(image)
        price.text = "฿ "+data.productPrice.toString()
        name.text = data.productName.toString()
        rate.text = data.review.get(0).rate.toString().toDouble().toString()
        brand.text = data.info.brand.toString()
        series.text = data.info.series.toString()
        detail.text = data.info.detail.toString()

        plus.setOnClickListener { increaseInteger(data.Stock) }
        minus.setOnClickListener { decreaseInteger() }
        buy.setOnClickListener{gotoShipping(data,unit.text.toString())}
    }
     fun gotoMainPage(v:View){
        val intent = Intent(v.context, MainActivity::class.java)
        startActivity(intent)
    }
    fun increaseInteger(stock:Int) {
        try{
            if(unit.text.toString().toInt() < stock) {
                display(unit.text.toString().toInt() + 1)
            }else{
            }
        }
        catch (e:Exception){

            display( 1)
        }
    }

    fun decreaseInteger() {

        try{
            if(unit.text.toString().toInt() <= 1){
            }else {
                display(unit.text.toString().toInt() - 1)
            }
        }
        catch (e:Exception){

            display( 1)
        }
    }

    private fun display(number: Int) {
        unit.setText("$number")
    }

    fun gotoShipping(data:Product,unit:String){
        val intent = Intent(this, ShippingActivity::class.java)
        val gson = Gson()

        var dataaddress: Address = Address("","","","","","")
        var shopping :Shopping = Shopping(data, dataaddress, "",unit)
        intent.putExtra("data", gson.toJson(shopping))
        startActivity(intent)
    }
}