package dev.davveg.coffeeshops

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter  (private val dataSet: Array<CardProduct>) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Define click listener for the ViewHolder's View
        val imageView: ImageView = view.findViewById(R.id.cardImage)
        val textTitle: TextView = view.findViewById(R.id.cardTitleText)
        val ratingBar: RatingBar = view.findViewById(R.id.cardRatingBar)
        val ratingNumber: TextView = view.findViewById(R.id.cardRatinNumber)
        val textAddress: TextView = view.findViewById(R.id.cardTextAddress)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_item, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val resource = dataSet.get(position)
        viewHolder.imageView.setImageResource(resource.imageView)
        viewHolder.textTitle.setText(resource.textTitle)
        viewHolder.ratingNumber.setText("0.0")
        viewHolder.textAddress.setText(resource.textAddress)







    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}