package com.example.mealz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mealz.di.MealsAdapter
import com.example.mealz.di.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModle: MealsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView = findViewById(R.id.category_rv)

        viewModle.getMeals()
        val mealsAdapter = MealsAdapter()

        lifecycleScope.launch {
            viewModle.categories.collect{
                mealsAdapter.submitList(it?.categories)
                rv.adapter = mealsAdapter

            }
        }


    }
}