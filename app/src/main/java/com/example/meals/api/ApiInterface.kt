package com.example.meals.api

import com.example.meals.models.category.CategoryResponse
import com.example.meals.models.recipe.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("categories.php")
    suspend fun getCategoryList(): Response<CategoryResponse>

    @GET("filter.php")
    suspend fun getCategoryRecipes(@Query("c") query:String): Response<RecipeResponse>

}