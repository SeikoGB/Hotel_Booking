package com.example.hotelbooking.Model

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelbooking.R

class CategoryAdapter(var array:MutableList<Category>,var onclick: onClick): RecyclerView.Adapter<CategoryAdapter.MyHolder>() {
    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var category_name=itemView.findViewById<TextView>(R.id.category_name)
        var costrain=itemView.findViewById<ConstraintLayout>(R.id.category_back)
        var category_card=itemView.findViewById<CardView>(R.id.category_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return CategoryAdapter.MyHolder(view)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var temp=array[position]
        holder.category_card.setOnClickListener {
            onclick.setOnClick(temp)
        }
        if (temp.isChecked){
        holder.costrain.setBackgroundColor(Color.GREEN)
        holder.category_name.resources.getColor(R.color.white)
        }
        holder.category_name.text=temp.name
    }
    interface onClick{
        fun setOnClick(temp:Category){}
    }
}