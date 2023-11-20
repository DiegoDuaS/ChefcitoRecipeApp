package com.example.chefcitorecipeapp.navigation.navGraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.chefcitorecipeapp.navigation.Screen
import com.example.chefcitorecipeapp.ui.PantallaInicio.View.InicioScreen
import com.example.chefcitorecipeapp.ui.SignIn.View.SigninScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(
        startDestination = Screen.Login.route,
        route = "Authentication") {
        composable(route = Screen.Login.route) {
            InicioScreen(navController = navController)
        }
        composable(route = Screen.SignIn.route) {
            SigninScreen(navController = navController)
        }
    }

}


