package com.example.meals.listeners

import com.example.meals.models.search.Meal

interface RecipeClickListener {
    fun onRecipeClick(meal:Meal)
}