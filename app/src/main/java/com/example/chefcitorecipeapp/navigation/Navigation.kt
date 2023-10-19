package com.example.chefcitorecipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.chefcitorecipeapp.navigation.navGraphs.authNavGraph
import com.example.chefcitorecipeapp.navigation.navGraphs.mainNavGraph

@Composable
fun Chefcito() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Authentication", route = "Root"){
        mainNavGraph(navController)
        authNavGraph(navController)

    }
}

