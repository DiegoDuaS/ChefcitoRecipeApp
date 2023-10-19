package com.example.chefcitorecipeapp.navigation.navGraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.chefcitorecipeapp.navigation.Screen
import com.example.chefcitorecipeapp.ui.Despensa.View.DespensaScreen
import com.example.chefcitorecipeapp.ui.NuevaReceta.View.NewRecipeScreen
import com.example.chefcitorecipeapp.ui.PantallaPrincipal.View.MainScreen
import com.example.chefcitorecipeapp.ui.Receta.View.RecetaScreen

fun NavGraphBuilder.mainNavGraph(navController: NavHostController){
    navigation(
        startDestination = Screen.MainScreen.route,
        route = "Main"
    ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.Receta.route) {
            RecetaScreen(navController = navController)
        }
        composable(route = Screen.Despensa.route) {
            DespensaScreen(navController = navController)
        }
        composable(route = Screen.NewReceta.route) {
            NewRecipeScreen(navController = navController)
        }
    }

}