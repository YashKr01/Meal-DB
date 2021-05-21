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

class SavedMealAdapter(private val list: List<Meal>) :
    RecyclerView.Adapter<SavedMealAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_saved_recipes, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val currentItem = list[position]

        holder.apply {
            image.load(currentItem.image)
            name.text = currentItem.name
            location.text = currentItem.location
            category.text = currentItem.category
        }

    }

    override fun getItemCount(): Int = list.size

    inner class ItemViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val image: ImageView = item.findViewById(R.id.txt_saved_meal_image)
        val name: TextView = item.findViewById(R.id.txt_saved_meal_name)
        val location: TextView = item.findViewById(R.id.txt_saved_meal_location)
        val category: TextView = item.findViewById(R.id.txt_saved_meal_category)
    }

}