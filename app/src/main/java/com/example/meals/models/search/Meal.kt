package com.example.meals.models.search

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Meal(
    @Expose
    @SerializedName("idMeal")
    val id: String,
    @Expose
    @SerializedName("strArea")
    val location: String,
    @Expose
    @SerializedName("strCategory")
    val category: String,
    @Expose
    @SerializedName("strYoutube")
    val link: String,
    @Expose
    @SerializedName("strMeal")
    val name: String,
    @Expose
    @SerializedName("strMealThumb")
    val image: String,
    @Expose
    @SerializedName("strInstructions")
    val instruction: String,
    @Expose
    @SerializedName("strTags")
    val tags: String
)