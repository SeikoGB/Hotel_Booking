package com.example.hotelbooking.Model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelbooking.R

class BigHotelAdapter(var array:MutableList<Hotel>,var onclick:onClick):RecyclerView.Adapter<BigHotelAdapter.MyHolder>() {
    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var layout=itemView.findViewById<ConstraintLayout>(R.id.cl)
        var reyting=itemView.findViewById<TextView>(R.id.rating)
        var hotel_name=itemView.findViewById<TextView>(R.id.hotel_name)
        var hotel_location=itemView.findViewById<TextView>(R.id.location)
        var hotel_price=itemView.findViewById<TextView>(R.id.price)
        var hotel_card=itemView.findViewById<CardView>(R.id.big_hotel_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view =LayoutInflater.from(parent.context).inflate(R.layout.hotel_big_item,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var temp=array[position]
        holder.layout.setBackgroundResource(temp.main_photo)
        holder.hotel_name.text=temp.name
        holder.hotel_location.text=temp.location
        holder.reyting.text=temp.rating.toString()
        holder.hotel_price.text="$"+temp.price_pernight.toString()
        holder.hotel_card.setOnClickListener {
            onclick.setOnClick(temp)
        }
    }
    interface onClick{
        fun setOnClick(temp:Hotel){}
    }
}