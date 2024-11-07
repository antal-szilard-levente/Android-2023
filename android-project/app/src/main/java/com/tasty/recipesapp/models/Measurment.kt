package com.tasty.recipesapp.models

import com.tasty.recipesapp.dtos.UnitDTO

data class Measurment(
    val quantity : Int,
    val unit: UnitDTO
)
