package dev.davidvega.elsol

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
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

        val x = findViewById(R.id.my_toolbar) as Toolbar
        x.inflateMenu(R.menu.menu_main)
        x.setOnMenuItemClickListener{
            when (it.itemId) {
                R.id.comparePlanets -> {
                    changeToComparePlanets()
                true
                }

                else -> {false}
            }
        }



        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,2)

        val dataSet = arrayListOf(
            Planeta("Espiculas", R.drawable.espiculas),
            Planeta("Filamentos", R.drawable.filamentos),
            Planeta("Mancha solar", R.drawable.manchasolar),
            Planeta("Corona solar", R.drawable.corona_solar),
            Planeta("Magnetosfera", R.drawable.magnetosfera),
            Planeta("Erupcion solar", R.drawable.erupcionsolar)
        )

        recyclerView.adapter = object : RecyclerView.Adapter<MyViewHolder>() {

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item, parent, false)
                return MyViewHolder(view)
            }

            override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                val resource = dataSet.get(position)
                holder.itemLayout.setBackgroundResource(resource.imageViewId)
                holder.textView.text = resource.nombre


                if ( holder.toolbar.menu.size() == 0) {
                    holder.toolbar.inflateMenu(R.menu.menu_item)
                }
                holder.toolbar.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.copy -> {
                            val originalItem: Planeta  = dataSet[position]
                            val copia: Planeta = Planeta( originalItem.nombre + " (Copia)", originalItem.imageViewId )
                            dataSet.add( position + 1, copia )
                            notifyItemInserted(position+1 )
                            notifyDataSetChanged()


                        }
                        R.id.delete -> {

                        }
                    }

                    false
                }
            }
            override fun getItemCount(): Int = dataSet.size
        }


    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemLayout: LinearLayout = itemView.findViewById(R.id.itemLayout)
        val toolbar: Toolbar = itemView.findViewById(R.id.itemToolbar)
        val textView: TextView = itemView.findViewById(R.id.textoCard)
    }

    fun changeToComparePlanets() {
        val i = Intent(this, CompararPlanetas::class.java)
        startActivity(i);
    }


}

