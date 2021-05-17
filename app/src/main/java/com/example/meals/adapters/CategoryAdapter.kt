package com.example.meals.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.meals.R
import com.example.meals.listeners.CategoryClickListener
import com.example.meals.models.category.Category

class CategoryAdapter(
    private var list: List<Category>,
    private val context: Context,
    private val listener: CategoryClickListener
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.img_item_category)
        val name: TextView = itemView.findViewById(R.id.txt_category_name)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        val category: Category = list.get(position)
        holder.name.text = category.name
        holder.image.load(category.image) {
            crossfade(true)
        }
        holder.image.setOnClickListener {
            listener.categoryClickListener(category)
        }

    }

    override fun getItemCount() = list.size

}