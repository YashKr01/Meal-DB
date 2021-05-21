package com.example.meals.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.meals.models.search.Meal

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(meal: Meal)

    @Delete
    suspend fun deleteMeal(meal: Meal)

    @Query("SELECT * FROM MEAL")
    fun getMeals(): LiveData<List<Meal>>

}