package com.example.pruebapc.ui.Screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home"){
        composable("Home") {
            HomeScreen{
                navController.navigate("MovieList")
            }
        }
        composable("MovieList") {
            MovieListScreen()
        }
    }
}