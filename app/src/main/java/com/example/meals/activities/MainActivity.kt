package com.example.meals.activities

import android.content.Intent
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
    private val recipeList = ArrayList<CategoryRecipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryAdapter = CategoryAdapter(categoryList, this, this)
        recipeAdapter = CategoryRecipeAdapter(recipeList, this, this)

        binding.categoriesRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            adapter = categoryAdapter
        }

        binding.recipesRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MainActivity)
            adapter = recipeAdapter
        }

        viewModel.getCategoryList().observe(this, { list ->
            categoryList.clear()
            categoryList.addAll(list)
            categoryAdapter.notifyDataSetChanged()
        })

        binding.edittext.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        binding.edittext.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

    }

    override fun categoryClickListener(category: Category) {

        binding.textView2.text = category.name

        viewModel.getCategoryRecipes(category.name).observe(this, {
            recipeList.clear()
            recipeList.addAll(it)
            recipeAdapter.notifyDataSetChanged()
        })
    }

    override fun categoryRecipeClickListener(recipe: CategoryRecipe) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("QUERY", recipe.id)
        startActivity(intent)
    }

}