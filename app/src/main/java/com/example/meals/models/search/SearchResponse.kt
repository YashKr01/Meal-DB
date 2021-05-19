package com.example.meals.models.search

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @Expose
    @SerializedName("meals")
    val searchedRecipeList: List<Meal>
)