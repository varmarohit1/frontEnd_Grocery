package com.klu.onlinegrocery

//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
//class BananalayoutActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.bananalayout)
//    }
//}

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BananalayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bananalayout) // or your actual layout XML file

        val itemImage = intent.getIntExtra("itemImage", R.drawable.default_image) // fallback
        val itemName = intent.getStringExtra("itemName")
        val itemDescription = intent.getStringExtra("itemDescription")
        val itemPrice = intent.getStringExtra("itemPrice")

        // Find views
        val imageView: ImageView = findViewById(R.id.itemImage)
        val nameView: TextView = findViewById(R.id.itemName)
        val descriptionView: TextView = findViewById(R.id.itemDescription)
        val priceView: TextView = findViewById(R.id.itemPrice)
        val buyButton: Button = findViewById(R.id.buyButton)

        // Set the values dynamically
        // ✅ Use the values that were passed via Intent
        imageView.setImageResource(itemImage)
        nameView.text = itemName
        descriptionView.text = itemDescription
        priceView.text = itemPrice
    }
}
