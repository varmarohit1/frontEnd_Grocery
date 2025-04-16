package com.klu.onlinegrocery

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.cardview.widget.CardView

class Bakery_Snack : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bakery_snack)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // CardView click listeners
        findViewById<CardView>(R.id.bread_bs).setOnClickListener {
            launchBakeryItemScreen(
                R.drawable.bread,
                "Bread",
                "Freshly baked bread, soft and perfect for sandwiches.",
                "₹40 per loaf"
            )
        }

        findViewById<CardView>(R.id.cookies_bs).setOnClickListener {
            launchBakeryItemScreen(
                R.drawable.cookies,
                "Cookies",
                "Crunchy, sweet cookies made with butter and chocolate chips.",
                "₹120 per box"
            )
        }

        findViewById<CardView>(R.id.cake_bs).setOnClickListener {
            launchBakeryItemScreen(
                R.drawable.cake,
                "Cake",
                "Delicious cakes available in a variety of flavors.",
                "₹350 per kg"
            )
        }

        findViewById<CardView>(R.id.muffins_bs).setOnClickListener {
            launchBakeryItemScreen(
                R.drawable.muffins,
                "Muffins",
                "Soft and fluffy muffins, perfect for your tea-time.",
                "₹60 per piece"
            )
        }

        findViewById<CardView>(R.id.donuts_bs).setOnClickListener {
            launchBakeryItemScreen(
                R.drawable.donuts,
                "Donuts",
                "Sweet, ring-shaped donuts with colorful glaze.",
                "₹50 per piece"
            )
        }

        findViewById<CardView>(R.id.pastries_bs).setOnClickListener {
            launchBakeryItemScreen(
                R.drawable.pastries,
                "Pastries",
                "Creamy and fruity pastries for every celebration.",
                "₹80 per piece"
            )
        }
    }

    private fun launchBakeryItemScreen(imageRes: Int, name: String, desc: String, price: String) {
        val intent = Intent(this, BananalayoutActivity::class.java)
        intent.putExtra("itemImage", imageRes)
        intent.putExtra("itemName", name)
        intent.putExtra("itemDescription", desc)
        intent.putExtra("itemPrice", price)
        startActivity(intent)
    }
}
