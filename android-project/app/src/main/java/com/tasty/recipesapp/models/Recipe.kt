package com.tasty.recipesapp.models

import com.tasty.recipesapp.dtos.ComponentDTO
import com.tasty.recipesapp.dtos.InstructionDTO
import com.tasty.recipesapp.dtos.NutritionDTO

data class Recipe (
    val recipeID: Int,
    val name: String,
    val description: String,
    val thumbnailUrl: String,
    val keywords: String,
    val isPublic: Boolean,
    val userEmail: String,
    val originalVideoUrl: String,
    val country: String,
    val numServings: Int,
    val components: List <Component>,
    val instructions:List  <Instruction>,
    val nutrition: Nutrition
)
