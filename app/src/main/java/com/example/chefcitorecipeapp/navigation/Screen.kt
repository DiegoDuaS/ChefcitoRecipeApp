package com.example.chefcitorecipeapp.navigation

sealed class Screen(val route: String) {
    object Login: Screen(route = "screen_inicial")
    object SignIn: Screen(route = "screen_signin")
    object MainScreen: Screen(route = "screen_principal")
    object Despensa: Screen(route = "screen_despensa")
    object Receta: Screen(route = "screen_receta/{id}")
    object NewReceta: Screen(route = "screen_new_receta")

}