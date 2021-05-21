package com.example.meals.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import com.example.meals.databinding.ActivityDetailsBinding
import com.example.meals.models.search.Meal
import com.example.meals.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val viewModel: DetailsViewModel by viewModels()
    private lateinit var meal: Meal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val query: String = intent.getStringExtra("QUERY")!!

        viewModel.getRecipeDetails(query).observe(this, { response ->
            binding.imgDetailsImage.load(response.image) {
                crossfade(true)
            }

            meal = response

            binding.txtCategory.text = response.category
            binding.txtDetailsInstructions.text = response.instruction
            binding.txtDetailsLink.text = response.link
            binding.txtDetailsName.text = response.name
            binding.txtTags.text = response.tags
            binding.txtDetailsRegion.text = response.location
        })

        binding.icSave.setOnClickListener {
            val item = Meal(
                meal.id,
                meal.location,
                meal.category,
                meal.link,
                meal.name,
                meal.image,
                meal.instruction,
                meal.tags
            )

            viewModel.insertRecipes(item)
        }


    }
}