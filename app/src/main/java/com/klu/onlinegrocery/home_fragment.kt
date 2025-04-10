package com.klu.onlinegrocery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
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
            startActivity(intent)
        }

        return binding.root
    }
}
