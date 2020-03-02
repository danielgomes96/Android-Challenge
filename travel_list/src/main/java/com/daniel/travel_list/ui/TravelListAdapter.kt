package com.daniel.travel_list.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daniel.core.extension.convertToCurrency
import com.daniel.core.extension.renderUrl
import com.daniel.domain.entity.Travel
import com.daniel.travel_list.R

class TravelListAdapter(
    private val context: Context,
    private val clickItem:(Travel) -> Unit
): RecyclerView.Adapter<TravelListAdapter.Holder>() {

    companion object {
        private const val CURRENCY_CODE = "BRL"
    }

    private val travelsList = mutableListOf<Travel>()

    fun setItems(list: List<Travel>) {
        if (!travelsList.containsAll(list)) {
            travelsList.addAll(list)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate((R.layout.item_travel), parent, false))
    }

    override fun getItemCount(): Int {
        return travelsList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(travelsList[position], context, clickItem)
    }

    inner class Holder(view: View): RecyclerView.ViewHolder(view) {
        private val tvTitle: TextView = view.findViewById(R.id.item_travel_title)
        private val tvPrice: TextView = view.findViewById(R.id.item_travel_price)
        private val tvDescription: TextView = view.findViewById(R.id.item_travel_description)
        private val imImage: ImageView = view.findViewById(R.id.item_travel_image)

        fun bind(travel: Travel, context: Context, clickItem: (Travel) -> Unit) {
            tvTitle.text = travel.title
            tvPrice.text = travel.price?.convertToCurrency(CURRENCY_CODE)
            tvDescription.text = travel.description

            itemView.setOnClickListener {
                clickItem(travel)
            }

            travel.imageUrl?.let { imageUrl ->
                imImage.renderUrl(context, imageUrl)
            }
        }
    }

}