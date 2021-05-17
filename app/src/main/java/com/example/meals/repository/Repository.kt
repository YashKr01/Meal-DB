package com.example.meals.repository

import com.example.meals.api.ApiInterface
import com.example.meals.models.category.CategoryResponse
import com.example.meals.models.recipe.RecipeResponse
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun getCategoriesList(): Response<CategoryResponse> =
        apiInterface.getCategoryList()


    suspend fun getCategoryRecipes(query: String): Response<RecipeResponse> =
        apiInterface.getCategoryRecipes(query)

}