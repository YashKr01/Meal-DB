package com.example.meals.repository

import androidx.lifecycle.LiveData
import com.example.meals.database.MealDao
import com.example.meals.models.search.Meal
import javax.inject.Inject

class DatabaseRepository @Inject constructor(private val mealDao: MealDao) {

    suspend fun insertMeal(meal: Meal) =
        mealDao.insertMeal(meal)

    fun getList(): LiveData<List<Meal>> =
        mealDao.getMeals()

}