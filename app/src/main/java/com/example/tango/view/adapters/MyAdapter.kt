package com.example.tango.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tango.R
import com.example.tango.domain.models.MyModel

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private var positions: List<MyModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_position, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(positions[position])
    }

    override fun getItemCount(): Int {
        return positions.size
    }

    fun update(positions: List<MyModel>) {
        this.positions = positions
        notifyDataSetChanged()
    }
}

class MyViewHolder(root: View) : RecyclerView.ViewHolder(root) {

    private val titleTextView = root.findViewById<TextView>(R.id.itemPositionTitle)
    private val subtitleTextView = root.findViewById<TextView>(R.id.itemPositionSubtitle)

    fun bind(model: MyModel) {
        titleTextView.text = model.title
        subtitleTextView.text = model.subTitle
    }
}