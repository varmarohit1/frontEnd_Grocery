package com.klu.onlinegrocery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView

class search_fragmant_1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_fragmant_1, container, false)

        // Fresh Fruits
        view.findViewById<CardView>(R.id.Fresh_Fruits).setOnClickListener {
            val intent = Intent(requireContext(), Fresh_Fruits::class.java)
            startActivity(intent)
        }

        // Cooking Oil & Ghee
        view.findViewById<CardView>(R.id.cookingOilGhee).setOnClickListener {
            val intent = Intent(requireContext(), cooking_oil_ghee::class.java)
            startActivity(intent)
        }

        // Meat & Fish
        view.findViewById<CardView>(R.id.Meat_Fish).setOnClickListener {
            val intent = Intent(requireContext(), Meat_Fish::class.java)
            startActivity(intent)
        }

        // Bakery & Snacks
        view.findViewById<CardView>(R.id.Bakery_Snacks).setOnClickListener {
            val intent = Intent(requireContext(), Bakery_Snack::class.java)
            startActivity(intent)
        }

        // Dairy & Eggs
        view.findViewById<CardView>(R.id.Dairy_Eggs).setOnClickListener {
            val intent = Intent(requireContext(), Dairy_Eggs::class.java)
            startActivity(intent)
        }

        // Beverages
        view.findViewById<CardView>(R.id.Beverages).setOnClickListener {
            val intent = Intent(requireContext(), Beverages::class.java)
            startActivity(intent)
        }

        return view
    }
}
