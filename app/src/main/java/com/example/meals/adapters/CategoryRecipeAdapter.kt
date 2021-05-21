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
import com.example.meals.models.recipe.CategoryRecipe
import com.example.meals.utils.Constants.Companion.LOREN_IPSUM

class CategoryRecipeAdapter(
    private var list: List<CategoryRecipe>,
    private val context: Context,
    private val listener: CategoryClickListener
) : RecyclerView.Adapter<CategoryRecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.txt_saved_meal_image)
        val name: TextView = itemView.findViewById(R.id.txt_saved_meal_name)
        val description: TextView = itemView.findViewById(R.id.txt_saved_meal_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder =
        RecipeViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_recipes, parent, false)
        )


    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        val currentItem = list[position]

        holder.apply {
            image.load(currentItem.image)
            name.text = currentItem.name
            description.text = LOREN_IPSUM
        }

        holder.image.setOnClickListener {
            listener.categoryRecipeClickListener(currentItem)
        }

    }


    override fun getItemCount() = list.size

}