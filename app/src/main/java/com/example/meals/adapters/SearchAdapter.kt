package com.example.meals.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.meals.R
import com.example.meals.listeners.RecipeClickListener
import com.example.meals.models.search.Meal

class SearchAdapter(private val list: List<Meal>, private val listener: RecipeClickListener) :
    RecyclerView.Adapter<SearchAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_search_recipe, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val currentItem = list[position]

        holder.name.text = currentItem.name
        holder.image.load(currentItem.image) {
            crossfade(true)
        }

        holder.image.setOnClickListener {
            listener.onRecipeClick(currentItem)
        }

    }

    override fun getItemCount(): Int = list.size

    inner class ItemViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val image: ImageView = item.findViewById(R.id.img_search_recipe)
        val name: TextView = item.findViewById(R.id.txt_search_recipe)
    }

}