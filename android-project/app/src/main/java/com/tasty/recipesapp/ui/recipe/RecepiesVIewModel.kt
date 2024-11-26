package com.tasty.recipesapp.ui.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.models.Recipe
import com.tasty.recipesapp.repositories.RecipeRepository
import com.tasty.recipesapp.repositories.RepositoryProvider
import kotlinx.coroutines.launch

private const val ARG_PARAM1 = "id"
class RecipesViewModel: ViewModel() {
    private val recipeList = MutableLiveData<List<Recipe>>()
    val recipes : LiveData<List<Recipe>> = recipeList


    fun loadRecipeData() {
        fun getRecipeById(id: Long)  {
            viewModelScope.launch {
                recipeList.value = RepositoryProvider.recipeRepository.getRecipes()
            }
    }

}