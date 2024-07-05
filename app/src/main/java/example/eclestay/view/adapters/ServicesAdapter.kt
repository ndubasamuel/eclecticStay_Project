//package example.eclestay.view.adapters
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import example.eclestay.R
//import example.eclestay.data.network.Responses.Menu
//import example.eclestay.data.network.Responses.Service
//
//class TopScrollAdapter(val menuCard: ArrayList<>): RecyclerView.Adapter<TopScrollAdapter.TopViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder {
//        val topView = LayoutInflater.from(parent.context).inflate(R.layout.top_scroll_bar, parent, false)
//        return TopViewHolder(topView)
//    }
//
//    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {
//        val menuItem = menuCard[position]
//        holder.itemView.apply {
//            holder.textView.text = menuItem.
//            holder.textView.text =
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return menuCard.size
//    }
//
//
//    class TopViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        val textView: TextView = itemView.findViewById(R.id.menuName)
//        val textView1: TextView = itemView.findViewById(R.id.menuServices)
//        val textView2: TextView = itemView.findViewById(R.id.menuAmenities)
//        val textView3: TextView = itemView.findViewById(R.id.menuCounties)
//
//    }
//}