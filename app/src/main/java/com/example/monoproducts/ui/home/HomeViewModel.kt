package com.example.monoproducts.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.monoproduct.Model.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    fun getJsonDataFromAsset(context: Context): Product? {
        val fileName:String = "Product.json"
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        Log.i("data", jsonString.toString())

        val gson = Gson()
        val listPersonType = object : TypeToken<Product>() {}.type

        var product: Product = gson.fromJson(jsonString, listPersonType)
        return product
    }
}