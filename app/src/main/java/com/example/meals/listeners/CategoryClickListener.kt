package com.example.meals.listeners

import com.example.meals.models.category.Category
import com.example.meals.models.recipe.CategoryRecipe

interface CategoryClickListener {
    fun categoryClickListener(category: Category)
    fun categoryRecipeClickListener(recipe: CategoryRecipe)
}