package com.leonardo.guideapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.leonardo.guideapp.R
import com.leonardo.guideapp.data.Guide

class GuideAdapter(private val dataSet: ArrayList<Guide>,private val urlListener : (String) -> Unit ): RecyclerView.Adapter<GuideAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.itemview, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val data: Guide = dataSet.get(position)

        holder.txtViewName.text = data.name
        holder.txtViewStartDate.text = data.startDate
        holder.txtViewEndDate.text = data.endDate
        Glide.with(holder.itemView.context).load(data.icon).into(holder.imageIcon)
        holder.itemView.tag = position

        holder.itemView.setOnClickListener {
            urlListener.invoke(data.url)
        }

    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var txtViewName: TextView = view.findViewById(R.id.name_view)
        var txtViewStartDate: TextView = view.findViewById(R.id.start_date)
        var txtViewEndDate: TextView = view.findViewById(R.id.end_date)
        var imageIcon: ImageView = view.findViewById(R.id.icon_view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }



}