package dev.davidvega.travels

import android.os.Bundle
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.ViewSwitcher
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

        val imageSwitcher: ImageSwitcher = findViewById(R.id.image_switcher)
        imageSwitcher.setFactory {
            val imgView = ImageView(applicationContext)
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView.setPadding(8, 8, 8, 8)
            imgView
        }
        imageSwitcher.setImageResource(R.drawable.image1)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        val dataset = arrayOf(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7,
                R.drawable.image8, R.drawable.image9, R.drawable.image10)
        val customAdapter = ImageAdapter(dataset)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = customAdapter

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

    }
}