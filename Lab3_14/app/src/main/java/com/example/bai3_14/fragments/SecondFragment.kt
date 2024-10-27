package com.example.bai3_14.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai3_14.R
import com.google.android.gms.analytics.ecommerce.Product
import com.example.bai3_14.adapters.ProductAdapter
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {
    private val cart = mutableListOf<Product>() // Lấy từ FirstFragment (có thể dùng ViewModel)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewCart.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewCart.adapter = ProductAdapter(cart) {}
    }
}
