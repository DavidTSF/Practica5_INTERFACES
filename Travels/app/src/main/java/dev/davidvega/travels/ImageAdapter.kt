package dev.davidvega.travels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter (private val dataSet: Array<Int>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Define click listener for the ViewHolder's View
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val resource = dataSet.get(position)
        viewHolder.imageView.setImageResource(resource)

        viewHolder.itemView.setOnClickListener (object : View.OnClickListener {
            override fun onClick(view: View?) {
                val imageSwitcher = view?.rootView?.findViewById(R.id.image_switcher) as ImageSwitcher
                imageSwitcher.setImageResource(resource)
                imageSwitcher.startAnimation(AnimationUtils.loadAnimation( viewHolder.imageView.context, R.anim.slide_in))
            }

        })

        }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}