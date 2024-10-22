package com.movie.app

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.movie.app.Destination.BOOKMARK
import com.movie.app.Destination.HOME
import com.movie.home.HomeScreen

object Destination {
    const val HOME = "home"
    const val BOOKMARK = "bookmark"
}

@Composable
fun MovieNavGraph(
    navController: NavHostController = rememberNavController()
) {
    val startDestination by remember { mutableStateOf(HOME) }

    NavHost(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        navController = navController,
        startDestination = startDestination
    ) {
        composable(HOME) {
            HomeScreen()
        }
        composable(BOOKMARK) {}
    }
}
