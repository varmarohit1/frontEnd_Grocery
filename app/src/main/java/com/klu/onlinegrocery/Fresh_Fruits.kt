package com.klu.onlinegrocery
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.cardview.widget.CardView

class Fresh_Fruits : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fresh_fruits)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // CardView click listeners
        findViewById<CardView>(R.id.apple).setOnClickListener {
            launchFruitScreen(
                R.drawable.img_1,
                "Apple",
                "Red, juicy apples rich in fiber and vitamins.",
                "₹120 per kg"
            )
        }

        findViewById<CardView>(R.id.banana).setOnClickListener {
            launchFruitScreen(
                R.drawable.img,
                "Banana",
                "Sweet bananas full of potassium and energy.",
                "₹50 per dozen"
            )
        }

        findViewById<CardView>(R.id.mango).setOnClickListener {
            launchFruitScreen(
                R.drawable.mango,
                "Mango",
                "Tropical king of fruits - sweet and aromatic.",
                "₹90 per kg"
            )
        }

        findViewById<CardView>(R.id.grapes).setOnClickListener {
            launchFruitScreen(
                R.drawable.grapes,
                "Grapes",
                "Fresh green grapes with natural sweetness.",
                "₹70 per kg"
            )
        }

        findViewById<CardView>(R.id.orange).setOnClickListener {
            launchFruitScreen(
                R.drawable.orange,
                "Orange",
                "Citrus-rich juicy oranges with vitamin C.",
                "₹60 per kg"
            )
        }

        findViewById<CardView>(R.id.watermelon).setOnClickListener {
            launchFruitScreen(
                R.drawable.watermelon,
                "Watermelon",
                "Refreshing summer fruit loaded with water.",
                "₹40 per kg"
            )
        }
    }

    private fun launchFruitScreen(imageRes: Int, name: String, desc: String, price: String) {
        val intent = Intent(this, BananalayoutActivity::class.java)
        intent.putExtra("itemImage", imageRes)
        intent.putExtra("itemName", name)
        intent.putExtra("itemDescription", desc)
        intent.putExtra("itemPrice", price)
        startActivity(intent)
    }
}
