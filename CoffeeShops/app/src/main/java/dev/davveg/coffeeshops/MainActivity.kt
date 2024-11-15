package dev.davveg.coffeeshops

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycleList)

        val dataset = arrayOf(
            CardProduct(R.drawable.images, "Antico Coffee Greco", "St. Italy, Rome"),
            CardProduct(R.drawable.images1, "Antico Coffee Greco", "St. Italy, Rome"),
            CardProduct(R.drawable.images2, "Antico Coffee Greco", "St. Italy, Rome"),
            CardProduct(R.drawable.images3, "Antico Coffee Greco", "St. Italy, Rome"),
            CardProduct(R.drawable.images4, "Antico Coffee Greco", "St. Italy, Rome"),
            CardProduct(R.drawable.images5, "Antico Coffee Greco", "St. Italy, Rome"),
            CardProduct(R.drawable.images6, "Antico Coffee Greco", "St. Italy, Rome"),

        )



        val customAdapter = CardAdapter(dataset)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = customAdapter

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager


    }
}