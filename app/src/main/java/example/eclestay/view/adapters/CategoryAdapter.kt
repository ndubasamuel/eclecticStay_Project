package example.eclestay.view.adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import example.eclestay.R

class CategoryAdapter(): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.picImage)
        val textView1 : TextView = itemView.findViewById(R.id.titleText)
        val textView2 : TextView = itemView.findViewById(R.id.textView2)
        val imageView1: ImageView = itemView.findViewById(R.id.imageViewLocation)
        val textView3 : TextView = itemView.findViewById(R.id.textViewLocationName)
        val imageView2 : ImageView = itemView.findViewById(R.id.likeStar)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.category_viewholder, parent, false)
        return CategoryViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return itemCount
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {


    }
}