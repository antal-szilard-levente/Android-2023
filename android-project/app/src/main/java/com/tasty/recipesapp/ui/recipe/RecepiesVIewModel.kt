package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.R
import com.tasty.recipesapp.models.Instruction
import com.tasty.recipesapp.models.Recipe
import com.tasty.recipesapp.repositories.RecipeRepository

private const val ARG_PARAM1 = "id"
class RecipesViewModel: ViewModel() {
    private val recipeList = MutableLiveData<List<Recipe>>()
    val recipes : LiveData<List<Recipe>> = recipeList
    private val repository = RecipeRepository()

    fun loadRecipeData() {
        recipeList.value = repository.getRecipes()
    }

}