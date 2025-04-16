package com.klu.onlinegrocery

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.cardview.widget.CardView

class Beverages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beverages)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // CardView click listeners
        findViewById<CardView>(R.id.coffee).setOnClickListener {
            launchBeverageItemScreen(
                R.drawable.coffee,
                "Coffee",
                "Strong and aromatic brew to kickstart your day.",
                "₹80 per cup"
            )
        }

        findViewById<CardView>(R.id.tea).setOnClickListener {
            launchBeverageItemScreen(
                R.drawable.tea,
                "Tea",
                "Refreshing tea with a perfect blend of herbs.",
                "₹50 per cup"
            )
        }

        findViewById<CardView>(R.id.juice).setOnClickListener {
            launchBeverageItemScreen(
                R.drawable.juice,
                "Juice",
                "Freshly squeezed fruit juice with no added sugar.",
                "₹60 per glass"
            )
        }

        findViewById<CardView>(R.id.soft_drink).setOnClickListener {
            launchBeverageItemScreen(
                R.drawable.soft_drink,
                "Soft Drink",
                "Chilled and fizzy drinks to cool your thirst.",
                "₹40 per bottle"
            )
        }

        findViewById<CardView>(R.id.milkshake).setOnClickListener {
            launchBeverageItemScreen(
                R.drawable.milkshake,
                "Milkshake",
                "Creamy milkshakes in chocolate, vanilla, and strawberry.",
                "₹90 per glass"
            )
        }

        findViewById<CardView>(R.id.energy_drink).setOnClickListener {
            launchBeverageItemScreen(
                R.drawable.energy_drink,
                "Energy Drink",
                "Revitalizing drink packed with energy boosters.",
                "₹110 per can"
            )
        }
    }

    private fun launchBeverageItemScreen(imageRes: Int, name: String, desc: String, price: String) {
        val intent = Intent(this, BananalayoutActivity::class.java)
        intent.putExtra("itemImage", imageRes)
        intent.putExtra("itemName", name)
        intent.putExtra("itemDescription", desc)
        intent.putExtra("itemPrice", price)
        startActivity(intent)
    }
}
