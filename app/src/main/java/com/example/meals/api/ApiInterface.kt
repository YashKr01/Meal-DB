package com.example.meals.api

import com.example.meals.models.category.CategoryResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("categories.php")
    suspend fun getCategoryList(): Response<CategoryResponse>

}