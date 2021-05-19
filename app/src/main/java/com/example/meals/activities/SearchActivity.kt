package com.example.meals.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.example.meals.R
import com.example.meals.adapters.SearchAdapter
import com.example.meals.databinding.ActivitySearchBinding
import com.example.meals.models.search.Meal
import com.example.meals.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivitySearchBinding
    private val viewModel: SearchViewModel by viewModels()
    private lateinit var searchAdapter: SearchAdapter
    private var list = ArrayList<Meal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        searchAdapter = SearchAdapter(list)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = searchAdapter
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        val search = menu?.findItem(R.id.search)
        val searchView = search?.actionView as SearchView

        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(this)

        return true
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.getSearchedRecipes(query).observe(this, { result ->
            populateList(result)
        })
        return true
    }

    private fun populateList(result: List<Meal>) {
        list.clear()
        list.addAll(result)
        searchAdapter.notifyDataSetChanged()
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        list.clear()
        return true
    }

}