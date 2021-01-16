package id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import id.ac.ui.cs.mobileprogramming.nadhirsyah.helloworld.club.ClubContent.ClubItem
class MyItemRecyclerViewAdapter(
    private val values: MutableList<ClubItem>,
    private val viewModel: ClubsViewModel?
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_club, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.club
        holder.itemView.setOnClickListener{
            viewModel?.setClub(item.club, item.clubDetail)
            (holder.itemView.context as FragmentActivity).supportFragmentManager.beginTransaction().replace(R.id.list_club_fragment, ClubsFragment()).commit()
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}