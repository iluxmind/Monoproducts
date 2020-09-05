package com.example.monoproducts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.monoproducts.Model.Address
import com.example.monoproducts.Model.Shopping
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_address.*

class AddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)


        val gson = Gson()
        var  obj = intent.getStringExtra("data")
        var data: Shopping = gson.fromJson(obj, Shopping::class.java)

        confirmaddress.setOnClickListener{
            var fullname:String = fullname.text.toString()
            var tel:String = tel.text.toString()
            var province:String = province.text.toString()
            var district:String = district.text.toString()
            var zipcode:String = zipcode.text.toString()
            var detail:String = detail.text.toString()
            if(fullname.isEmpty() || tel.isEmpty() || province.isEmpty() || district.isEmpty() || zipcode.isEmpty()){
                val t = Toast.makeText(this,"กรุณากรอกข้อมูลให้ครบถ้วน", Toast.LENGTH_LONG)
                t.show()
            }else{

                var dataaddress: Address = Address(fullname,tel,province,district,zipcode,detail)
                var shopping :Shopping = Shopping(data.product, dataaddress, data.cash,data.unit)
                val intent = Intent(this, ShippingActivity::class.java)
                val gson = Gson()
                intent.putExtra("data", gson.toJson(shopping))
                startActivity(intent)
            }
        }
    }
}