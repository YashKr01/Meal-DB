package com.example.meals.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meals.models.category.Category
import com.example.meals.models.recipe.CategoryRecipe
import com.example.meals.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val data: MutableLiveData<List<Category>> = MutableLiveData()
    private val recipes: MutableLiveData<List<CategoryRecipe>> = MutableLiveData()

    fun getCategoryList(): MutableLiveData<List<Category>> {

        viewModelScope.launch {
            val response = repository.getCategoriesList()

            if (response.isSuccessful) data.postValue(response.body()?.categoryList)
            else data.postValue(null)

        }

        return data
    }

    fun getCategoryRecipes(q: String): MutableLiveData<List<CategoryRecipe>> {

        viewModelScope.launch {
            val response = repository.getCategoryRecipes(q)

            if (response.isSuccessful) recipes.postValue(response.body()?.list)
            else recipes.postValue(null)
        }

        return recipes
    }


}