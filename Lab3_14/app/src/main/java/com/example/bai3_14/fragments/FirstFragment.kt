package com.example.bai3_14.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai3_14.R
import com.example.bai3_14.adapters.Product
import com.example.bai3_14.adapters.ProductAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.example.bai3_14.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    private val products = listOf(
        Product("Product 1", 100),
        Product("Product 2", 200),
        Product("Product 3", 300)
    )
    private val cart = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Thiết lập RecyclerView
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewProducts.adapter = ProductAdapter(products) { product ->
            showAddToCartDialog(product)
        }

        // Xử lý sự kiện nút View Cart
        binding.buttonViewCart.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    private fun showAddToCartDialog(product: Product) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Add to Cart")
            .setMessage("Do you want to add ${product.name} to the cart?")
            .setPositiveButton("Yes") { _, _ ->
                cart.add(product)
                Snackbar.make(requireView(), "Product added to cart", Snackbar.LENGTH_SHORT).show()
            }
            .setNegativeButton("No", null)
            .show()
    }
}
