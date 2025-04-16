package com.klu.onlinegrocery

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class cooking_oil_ghee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cooking_oil_ghee)

        // Set up window insets to handle system bars and padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set click listeners for each item in the Cooking Oil & Ghee section
        findViewById<CardView>(R.id.sunflower_oil).setOnClickListener {
            launchDetailScreen(
                R.drawable.sunflower_oil,
                "Sunflower Oil",
                "Light and healthy oil perfect for cooking.",
                "₹140 per litre"
            )
        }

        findViewById<CardView>(R.id.groundnut_oil).setOnClickListener {
            launchDetailScreen(
                R.drawable.groundnut_oil,
                "Groundnut Oil",
                "Aromatic and nutritious oil for traditional cooking.",
                "₹160 per litre"
            )
        }

        findViewById<CardView>(R.id.ghee).setOnClickListener {
            launchDetailScreen(
                R.drawable.ghee,
                "Ghee",
                "Pure desi ghee made from cow’s milk.",
                "₹550 per kg"
            )
        }

        findViewById<CardView>(R.id.coconut_oil).setOnClickListener {
            launchDetailScreen(
                R.drawable.coconut_oil,
                "Coconut Oil",
                "Organic cold-pressed coconut oil.",
                "₹200 per 500ml"
            )
        }
    }

    private fun launchDetailScreen(imageRes: Int, name: String, desc: String, price: String) {
        val intent = Intent(this, BananalayoutActivity::class.java)
        intent.putExtra("itemImage", imageRes)
        intent.putExtra("itemName", name)
        intent.putExtra("itemDescription", desc)
        intent.putExtra("itemPrice", price)
        startActivity(intent)
    }
}
