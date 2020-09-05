package com.example.monoproducts.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monoproduct.Model.Product
import com.example.monoproduct.adapter.ProductAdapter
import com.example.monoproducts.R
import java.lang.Exception

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        //Get Data From ViewModel
        val list = ArrayList<Product?>()
        try{
        val data : Product? = HomeViewModel().getJsonDataFromAsset(requireContext())

       list.add(data)
        list.add(data)}
        catch (e:Exception){
            Log.d("Exeppppppppppppp",e.toString())
            list.add(null)
        }
        //set RecycleView Product
        recyclerView = root.findViewById(R.id.productView)
        viewManager = LinearLayoutManager(requireContext())
        viewAdapter = ProductAdapter(list,requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = viewAdapter
        return root
    }
}