package com.example.meals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meals.adapters.CategoryAdapter
import com.example.meals.adapters.CategoryRecipeAdapter
import com.example.meals.databinding.ActivityMainBinding
import com.example.meals.listeners.CategoryClickListener
import com.example.meals.models.category.Category
import com.example.meals.models.recipe.CategoryRecipe
import com.example.meals.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CategoryClickListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var recipeAdapter: CategoryRecipeAdapter
    private val categoryList = ArrayList<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryAdapter = CategoryAdapter(categoryList, this, this)
        recipeAdapter = CategoryRecipeAdapter(ArrayList(), this)

        binding.categoriesRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            adapter = categoryAdapter
        }

        viewModel.getCategoryList().observe(this, { list ->
            categoryList.clear()
            categoryList.addAll(list)
            categoryAdapter.notifyDataSetChanged()
        })

        binding.recipesRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            adapter = recipeAdapter
        }


    }

    override fun categoryClickListener(category: Category) {
        viewModel.getCategoryRecipes(category.name).observe(this, {
            recipeAdapter.setData(it)
        })
    }

}