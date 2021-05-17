package com.example.meals.models.recipe

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryRecipe(
    @Expose
    @SerializedName("idMeal")
    val id: String,
    @Expose
    @SerializedName("strMeal")
    val name: String,
    @Expose
    @SerializedName("strMealThumb")
    val image: String,
    @Expose
    @SerializedName("strCategoryDescription")
    val description: String
)