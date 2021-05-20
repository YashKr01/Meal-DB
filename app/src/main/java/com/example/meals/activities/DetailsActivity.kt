package com.example.meals.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import com.example.meals.databinding.ActivityDetailsBinding
import com.example.meals.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val query: String = intent.getStringExtra("QUERY")!!

        viewModel.getRecipeDetails(query).observe(this, { response ->
            binding.imgDetailsImage.load(response.image) {
                crossfade(true)
            }

            binding.txtCategory.text = response.category
            binding.txtDetailsInstructions.text = response.instruction
            binding.txtDetailsLink.text = response.link
            binding.txtDetailsName.text = response.name
            binding.txtTags.text = response.tags
            binding.txtDetailsRegion.text = response.location

        })


    }
}