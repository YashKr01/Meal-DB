package com.example.meals.models.recipe

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @Expose
    @SerializedName("meals")
    val recipeList: List<Recipe>
)
