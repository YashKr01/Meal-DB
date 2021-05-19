package com.example.meals.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meals.models.search.Meal
import com.example.meals.models.search.SearchResponse
import com.example.meals.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val data: MutableLiveData<List<Meal>> = MutableLiveData()

    fun getSearchedRecipes(query: String): MutableLiveData<List<Meal>> {

        viewModelScope.launch {

            val response = repository.getSearchedRecipes(query)
            if (response.isSuccessful) data.postValue(response.body()?.searchedRecipeList)
            else data.postValue(null)
        }

        return data
    }

}