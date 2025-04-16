package com.klu.onlinegrocery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.klu.onlinegrocery.databinding.FragmentHomeFragmentBinding


class home_fragment : Fragment() {
    private lateinit var binding: FragmentHomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeFragmentBinding.inflate(inflater, container, false)

        // Navigate to BananalayoutActivity on click
        binding.organicbanana.setOnClickListener {
            val intent = Intent(requireActivity(), BananalayoutActivity::class.java)

            // Send item data using intent extras
            intent.putExtra("itemImage", R.drawable.organic_bananas)
            intent.putExtra("itemName", "Organic Bananas")
            intent.putExtra("itemDescription", "Fresh and naturally ripened bananas.")
            intent.putExtra("itemPrice", "₹99")

            startActivity(intent)
        }

        return binding.root
    }
}
