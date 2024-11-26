package com.tasty.recipesapp.models

import com.tasty.recipesapp.dtos.UnitDTO

data class Measurement(
    val quantity : Int,
    val unit: UnitDTO
)
