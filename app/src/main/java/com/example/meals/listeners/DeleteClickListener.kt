package com.example.meals.listeners

import com.example.meals.models.search.Meal

interface DeleteClickListener {
    fun deleteItem(meal: Meal,position:Int)
}