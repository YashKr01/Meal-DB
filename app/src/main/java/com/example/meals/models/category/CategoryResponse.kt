package com.example.meals.models.category

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @Expose
    @SerializedName("categories") val categoryList: List<Category>
)
