package com.tasty.recipesapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import com.tasty.recipesapp.R
 import com.tasty.recipesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host)
        binding.bottomNavigation.setOnItemSelectedListener{
            /*Log.i("Menu", "Cliked")
            true*/

            when(it.itemId){
                R.id.homeFragment -> navController.navigate(R.id.homeFragment)
                R.id.profileFragment -> navController.navigate(R.id.profileFragment)
                R.id.recipeFragment -> navController.navigate(R.id.recipeFragment)
            }
            true
        }
    }
}