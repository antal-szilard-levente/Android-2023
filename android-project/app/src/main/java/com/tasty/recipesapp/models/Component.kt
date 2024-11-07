package com.tasty.recipesapp.models

import com.tasty.recipesapp.dtos.IngredientDTO

data class Component(
    val rawText : String,
    val extraComment: String,
    val ingredient: IngredientDTO,
    val position: Int
)
