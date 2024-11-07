package com.tasty.recipesapp.repositories

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tasty.recipesapp.models.Instruction

import com.tasty.recipesapp.dtos.InstructionDTO
import com.tasty.recipesapp.dtos.NutritionDTO
import com.tasty.recipesapp.dtos.RecipeDTO
import com.tasty.recipesapp.models.Recipe
import org.json.JSONObject

class RecipeRepository {

    val dummyDataRecipes = """
        [
            {
                "recipeID": 1,
                "name": "Avocado Chicken Salad",
                "description": "A tasty and healthy avocado chicken salad.",
                "thumbnailUrl": "https://www.slenderkitchen.com/sites/default/files/styles/gsd-1x1/public/recipe_images/avocado-chicken-salad.jpg",
                "keywords": "salad, avocado, chicken",
                "isPublic": true,
                "userEmail": "Unknown",
                "originalVideoUrl": "https://s3.amazonaws.com/video-api-prod/assets/a0e1b07dc71c4ac6b378f24493ae2d85/FixedFBFinal.mp4",
                "country": "US",
                "numServings": 4,
                "components": [],
                "instructions": []
            },
            {
                "recipeID": 2,
                "name": "Vegan Lentil Soup",
                "description": "A hearty vegan lentil soup.",
                "thumbnailUrl": "https://www.allrecipes.com/thmb/UeFtapHyGFBo4Lx-72GxgjrOGnk=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/13978-lentil-soup-DDMFS-4x3-edfa47fc6b234e6b8add24d44c036d43.jpg",
                "keywords": "soup, lentil, vegan",
                "isPublic": true,
                "userEmail": "Unknown",
                "originalVideoUrl": "https://www.youtube.com/watch?v=KSyi9U8Zwcc&ab_channel=MarthaStewart",
                "country": "UK",
                "numServings": 6,
                "components": [],
                "instructions": []
            },
            {
                "recipeID": 3,
                "name": "Classic Caesar Salad",
                "description": "A traditional Caesar salad with croutons and dressing.",
                "thumbnailUrl": "https://www.allrecipes.com/thmb/mXZ0Tulwn3x9_YB_ZbkiTveDYFE=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/229063-Classic-Restaurant-Caesar-Salad-ddmfs-4x3-231-89bafa5e54dd4a8c933cf2a5f9f12a6f.jpg",
                "keywords": "salad, caesar, classic",
                "isPublic": true,
                "userEmail": "Unknown",
                "originalVideoUrl": "https://www.google.com/search?q=ceasar+salad&sca_esv=1c412232e298010e&sca_upv=1&biw=1536&bih=695&tbm=vid&sxsrf=ADLYWIJOrXTFUvuqtW0Sx3qBi7VTqUt87g%3A1727071651852&ei=owXxZvnMM9-C9u8P0YnMkAY&ved=0ahUKEwi5qr2is9iIAxVfgf0HHdEEE2IQ4dUDCA0&uact=5&oq=ceasar+salad&gs_lp=Eg1nd3Mtd2l6LXZpZGVvIgxjZWFzYXIgc2FsYWQyCxAAGIAEGJECGIoFMgoQABiABBhDGIoFMgcQABiABBgKMgcQABiABBgKMgcQABiABBgKMgcQABiABBgKMgcQABiABBgKMgcQABiABBgKMgcQABiABBgKMgcQABiABBgKSJIDUABYAHAAeACQAQCYAW2gAW2qAQMwLjG4AQPIAQD4AQL4AQGYAgGgAniYAwCSBwMwLjGgB-sH&sclient=gws-wiz-video#fpstate=ive&vld=cid:dc55894c,vid:7Mi8DmbAE74,st:0",
                "country": "Canada",
                "numServings": 3,
                "components": [],
                "instructions": []
            }
        ]"""

    fun RecipeDTO.toModel(): Recipe {
        val nutrition = this.nutrition ?: NutritionDTO(0, 0, 0, 0, 0, 0)
        return Recipe(
            recipeID = this.recipeID,
            name = this.name,
            description = this.description,
            thumbnailUrl = this.thumbnailUrl,
            keywords = this.keywords,
            isPublic = this.isPublic,
            userEmail = this.userEmail,
            originalVideoUrl = this.originalVideoUrl,
            country = this.country,
            numServings = this.numServings,
            components = this.components,
            instructions = this.instructions,
            nutrition = nutrition)
    }

    fun List<RecipeDTO>.toModelList(): List<Recipe> {
        return this.map { it.toModel() }
    }

    fun loadRecipeDTOs(): List<RecipeDTO> {
        val gson = Gson()
        val recipeList: List<RecipeDTO> = gson.fromJson(dummyDataRecipes, object : TypeToken<List<RecipeDTO>>() {}.type)
        Log.i("GSON", recipeList.toString())
        return recipeList
    }

    fun getRecipes() = loadRecipeDTOs().toModelList()
}