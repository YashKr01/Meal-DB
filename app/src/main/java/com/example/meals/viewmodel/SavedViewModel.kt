package com.example.meals.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.meals.models.search.Meal
import com.example.meals.repository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(private val repository: DatabaseRepository) : ViewModel() {


    fun getList(): LiveData<List<Meal>> = repository.getList()


}