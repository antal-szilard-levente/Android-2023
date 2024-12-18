package com.tasty.recipesapp.api

import com.tasty.recipesapp.dtos.RecipeDTO
import retrofit2.http.GET

interface RecipeService {
    @GET("api/recipes")
    suspend fun getRecipes(): List<RecipeDTO>
}
