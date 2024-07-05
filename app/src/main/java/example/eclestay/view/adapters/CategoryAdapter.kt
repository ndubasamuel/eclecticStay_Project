//package example.eclestay.view.adapters
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.AsyncListDiffer
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import example.eclestay.Model.Category
//import example.eclestay.Model.CategoryItem
//import example.eclestay.R
//
//class CategoryAdapter(): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
//
//    class CategoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
//
////        val imageView: ImageView = itemView.findViewById(R.id.placeImage)
//        val textView: TextView = itemView.findViewById(R.id.tvPlaceName)
//        val textView1: TextView = itemView.findViewById(R.id.placeImage)
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
//        val categoryView = LayoutInflater.from(parent.context).inflate(R.layout.category_viewholder, parent, false)
//        return CategoryViewHolder(categoryView)
//    }
//
//
//    private val differCallBackStack = object : DiffUtil.ItemCallback<CategoryItem>() {
//        override fun areItemsTheSame(oldItem: CategoryItem , newItem: CategoryItem): Boolean {
//            return oldItem == newItem
//        }
//
//        override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem ): Boolean {
//            return false
//        }
//    }
//
//    val differ = AsyncListDiffer(this, differCallBackStack)
//
//    override fun getItemCount() :Int {
//        return differ.currentList.size
//    }
//
//    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
//        val category = differ.currentList[position]
//        holder.itemView.apply {
//            holder.textView.text = category.category_name
//            holder.textView1.text = category.category_id.toString()
//        }
//    }
//}