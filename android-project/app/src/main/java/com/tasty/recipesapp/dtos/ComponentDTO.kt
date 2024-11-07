package com.tasty.recipesapp.dtos

data class ComponentDTO (
    val rawText : String,
    val extraComment: String,
    val ingredient: IngredientDTO,
    val position: Int

)
