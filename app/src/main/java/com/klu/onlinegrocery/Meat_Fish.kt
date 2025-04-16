package com.klu.onlinegrocery

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Meat_Fish : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meat_fish)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // CardView click listeners for Meat & Fish
        findViewById<CardView>(R.id.chicken).setOnClickListener {
            launchMeatItemScreen(
                R.drawable.chicken,
                "Chicken",
                "Fresh, skinless chicken ideal for curries and grills.",
                "₹220 per kg"
            )
        }

        findViewById<CardView>(R.id.mutton).setOnClickListener {
            launchMeatItemScreen(
                R.drawable.mutton,
                "Mutton",
                "Tender goat meat, perfect for spicy mutton curry.",
                "₹650 per kg"
            )
        }

        findViewById<CardView>(R.id.fish).setOnClickListener {
            launchMeatItemScreen(
                R.drawable.fish,
                "Fish",
                "Fresh river fish rich in protein and omega-3.",
                "₹300 per kg"
            )
        }

        findViewById<CardView>(R.id.prawns).setOnClickListener {
            launchMeatItemScreen(
                R.drawable.prawns,
                "Prawns",
                "Juicy prawns, cleaned and ready to cook.",
                "₹480 per 500g"
            )
        }
    }

    private fun launchMeatItemScreen(imageRes: Int, name: String, desc: String, price: String) {
        val intent = Intent(this, BananalayoutActivity::class.java)
        intent.putExtra("itemImage", imageRes)
        intent.putExtra("itemName", name)
        intent.putExtra("itemDescription", desc)
        intent.putExtra("itemPrice", price)
        startActivity(intent)
    }
}
