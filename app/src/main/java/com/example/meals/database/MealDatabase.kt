package com.example.meals.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.meals.models.search.Meal

@Database(entities = [Meal::class], exportSchema = false, version = 1)
abstract class MealDatabase : RoomDatabase() {

    abstract fun mealDao(): MealDao

}