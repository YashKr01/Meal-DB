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
import com.example.meals.models.recipe.CategoryRecipe

class CategoryRecipeAdapter(private var list: List<CategoryRecipe>, private val context: Context) :
    RecyclerView.Adapter<CategoryRecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.img_item_recipe)
        val name: TextView = itemView.findViewById(R.id.txt_ite_recipe_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder =
        RecipeViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_recipes, parent, false)
        )


    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentItem = list.get(position)

        holder.apply {
            image.load(currentItem.image)
            name.text = currentItem.name
        }

    }

    fun setData(newList: List<CategoryRecipe>) {
        this.list = newList
        notifyDataSetChanged()
    }

    override fun getItemCount() = list.size

}