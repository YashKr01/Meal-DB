package com.example.meals.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meals.R
import com.example.meals.adapters.SavedMealAdapter
import com.example.meals.databinding.ActivitySavedBinding
import com.example.meals.models.search.Meal
import com.example.meals.viewmodel.SavedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySavedBinding
    private val viewModel: SavedViewModel by viewModels()
    private lateinit var savedAdapter: SavedMealAdapter
    private val list = ArrayList<Meal>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedAdapter = SavedMealAdapter(list)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@SavedActivity)
            adapter = savedAdapter
        }

        viewModel.getList().observe(this, {
            list.clear()
            list.addAll(it)
            savedAdapter.notifyDataSetChanged()
        })

    }
}