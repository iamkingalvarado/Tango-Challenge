package com.example.tango

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val recyclerView: RecyclerView by lazy { RecyclerView(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(recyclerView)
    }

    class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            TODO("Not yet implemented")
        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }
    }

    class MyViewHolder(root: View) : RecyclerView.ViewHolder(root) {
    }

    class MyModel(
        val title: String,
        val subTitle: String,
    )
}