package com.example.sports

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AthleteAdapter(private var listAthlete: ArrayList<Athlete>) : RecyclerView.Adapter<AthleteAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setFilteredList(filteredList: ArrayList<Athlete>) {
        this.listAthlete = filteredList
        notifyDataSetChanged()
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvSport: TextView = itemView.findViewById(R.id.tv_item_sport)
        val tvEarnings: TextView = itemView.findViewById(R.id.tv_item_earnings)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_athlete, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, sport, earnings, _, image) = listAthlete[position]

        Glide.with(holder.itemView.context)
            .load(image)
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvSport.text = sport
        holder.tvEarnings.text = earnings

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listAthlete[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listAthlete.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Athlete)
    }
}