package com.tasty.recipesapp.ui.recipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.models.Instruction


class RecipesViewModel : ViewModel() {

    private val instructionList = MutableLiveData<List<Instruction>>()

    init {

    }

}