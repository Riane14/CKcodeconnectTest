
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rianebenbrik.ckcodeconnecttest.R


class UserAdapter (var listusers: ArrayList<User>, val context: Context,
                   val itemClickListener: OnItemClickListener): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){


    fun setData(list: ArrayList<User>){
        listusers=list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = listusers[position]
        holder.nameText.text = item.firstName +" "+item.lastName
        Glide.with(context).load(item.picture).error(R.drawable.ic_baseline_account_box_24).into(holder.image)
        holder.bind(item,itemClickListener)

    }

    override fun getItemCount(): Int {
        return listusers.size
    }

    class UserViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val image: ImageView =view.findViewById(R.id.userimage)
        val nameText: TextView =view.findViewById(R.id.username)

        fun bind(user: User,clickListener: OnItemClickListener) {
            itemView.setOnClickListener {
                clickListener.onItemClicked(user)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClicked(user: User)
    }

}