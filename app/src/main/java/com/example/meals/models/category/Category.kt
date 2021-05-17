package com.example.meals.models.category

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(
    @Expose
    @SerializedName("idCategory")
    val id: String,
    @Expose
    @SerializedName("strCategory")
    val name: String,
    @Expose
    @SerializedName("strCategoryThumb")
    val image: String
)