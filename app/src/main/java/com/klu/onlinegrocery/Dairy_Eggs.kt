package com.klu.onlinegrocery

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Dairy_Eggs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dairy_eggs)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<CardView>(R.id.milk).setOnClickListener {
            launchDetail(R.drawable.milk, "Milk", "Fresh and organic milk.", "₹55/litre")
        }

        findViewById<CardView>(R.id.cheese).setOnClickListener {
            launchDetail(R.drawable.cheese, "Cheese", "Creamy cheese for your meals.", "₹200/500g")
        }

        findViewById<CardView>(R.id.butter).setOnClickListener {
            launchDetail(R.drawable.butter, "Butter", "Smooth and salted butter.", "₹180/250g")
        }

        findViewById<CardView>(R.id.eggs).setOnClickListener {
            launchDetail(R.drawable.eggs, "Eggs", "Farm-fresh eggs in every pack.", "₹75/12pcs")
        }

        findViewById<CardView>(R.id.paneer).setOnClickListener {
            launchDetail(R.drawable.paneer, "Paneer", "Soft paneer for curries.", "₹90/200g")
        }

        findViewById<CardView>(R.id.eggs).setOnClickListener {
            launchDetail(R.drawable.eggs, "Yogurt", "Cool and refreshing yogurt.", "₹30/cup")
        }
    }

    private fun launchDetail(imageRes: Int, name: String, desc: String, price: String) {
        val intent = Intent(this, BananalayoutActivity::class.java)
        intent.putExtra("itemImage", imageRes)
        intent.putExtra("itemName", name)
        intent.putExtra("itemDescription", desc)
        intent.putExtra("itemPrice", price)
        startActivity(intent)
    }
}
