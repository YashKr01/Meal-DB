package com.example.meals.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meals.models.search.Meal
import com.example.meals.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val data: MutableLiveData<Meal> = MutableLiveData()

    fun getRecipeDetails(query: String): MutableLiveData<Meal> {

        viewModelScope.launch {
            val response = repository.getRecipeDetails(query)

            if (response.isSuccessful) data.postValue(response.body()?.searchedRecipeList?.get(0))
            else data.postValue(null)
        }

        return data
    }

}