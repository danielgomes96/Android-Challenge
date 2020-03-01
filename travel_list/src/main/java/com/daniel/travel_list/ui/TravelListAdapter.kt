package com.daniel.travel_list.ui

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daniel.core.extension.renderUrl
import com.daniel.domain.entity.Travel
import com.daniel.travel_list.R

class TravelListAdapter(
    private val context: Context
): RecyclerView.Adapter<TravelListAdapter.Holder>() {

    private val usersList = mutableListOf<Travel>()

    fun setItems(list: List<Travel>) {
        if (!usersList.containsAll(list)) {
            usersList.addAll(list)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate((R.layout.item_travel), parent, false))
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(usersList[position], context)
    }

    inner class Holder(view: View): RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.item_travel_title)
        private val imImage: ImageView = view.findViewById(R.id.item_travel_image)

        fun bind(travel: Travel, context: Context) {
            title.text = travel.title
            travel.imageUrl?.let { imageUrl ->
                imImage.renderUrl(context, imageUrl)
            }
        }
    }

}