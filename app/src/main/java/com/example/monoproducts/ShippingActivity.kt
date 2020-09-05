package com.example.monoproducts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.monoproducts.Model.Shopping
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_shipping.*
import kotlinx.android.synthetic.main.activity_shipping.price
import java.io.File
import java.io.FileOutputStream

class ShippingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping)


        val gson = Gson()
        var  obj = intent.getStringExtra("data")
        val data: Shopping = gson.fromJson(obj, Shopping::class.java)



        val prices: Double = data.product!!.productPrice.toDouble() * data.unit!!.toDouble()

        shipprice.text = shippingprice.text
        val total: Double = prices + shipprice.text.toString().toDouble()
        if(data.address.fullname.isEmpty()){

        }else{
            address.text = data.address.fullname + " | " + data.address.tel + "\n" + data.address.detail +" อำเภอ"+ data.address.district+", จังหวัด"+data.address.province+","+data.address.zipcode
        }
        nameproduct.text = data.product!!.productName
        priceproduct.text = "฿"+data.product!!.productPrice.toString()
        unitproduct.text = "X"+ data.unit
        price.text = prices.toString()
        total1.text = total.toString()
        total2.text = total.toString()
        cash.text = data.cash
        val imageUrl = data.product!!.productImg.toString()
        Picasso.get().load(imageUrl).into(imagepd)

        btnaddress.setOnClickListener {
            val intent = Intent(this, AddressActivity::class.java)
            val gson = Gson()
            intent.putExtra("data", gson.toJson(data))
            startActivity(intent)
        }
        btncash.setOnClickListener {
            val intent = Intent(this, CashActivity::class.java)
            val gson = Gson()
            intent.putExtra("data", gson.toJson(data))
            startActivity(intent)
        }
        btnsubmit.setOnClickListener {
            if(data.cash.isEmpty() || data.cash.equals("") || data.address.fullname.equals("")){
                val t = Toast.makeText(this,"กรุณากรอกข้อมูลให้ครบถ้วน", Toast.LENGTH_LONG)
                t.show()
            }else{

                val gson = Gson()
                val fileName = "history.json"
                val fileBody = gson.toJson(data)

                openFileOutput(fileName, Context.MODE_PRIVATE).use { output ->
                    output.write(fileBody.toByteArray())
                }
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
        }
    }
}