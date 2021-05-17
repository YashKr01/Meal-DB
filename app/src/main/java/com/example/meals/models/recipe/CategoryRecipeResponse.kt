package com.example.meals.models.recipe

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryRecipeResponse(
    @Expose
    @SerializedName("meals")
    val list: List<CategoryRecipe>
)