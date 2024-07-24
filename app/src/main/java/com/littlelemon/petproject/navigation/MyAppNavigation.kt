package com.littlelemon.petproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.littlelemon.petproject.screens.FeedScreen
import com.littlelemon.petproject.screens.PersonalAccountScreen
import com.littlelemon.petproject.screens.SignInScreen
import com.littlelemon.petproject.screens.SignUpScreen
import com.littlelemon.petproject.screens.WorkoutArchiveScreen
import com.littlelemon.petproject.screens.WorkoutScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SignIn.route) {
        composable(Screen.SignIn.route) { SignInScreen(navController = navController) }
        composable(Screen.SignUp.route) { SignUpScreen(navController = navController) }
        composable(Screen.Feed.route) { FeedScreen(navController = navController) }
        composable(Screen.WorkOut.route) { WorkoutScreen(navController = navController) }
        composable(Screen.PersonalPage.route) { PersonalAccountScreen(navController = navController) }
        composable(Screen.Archive.route) { WorkoutArchiveScreen(navController = navController) }
    }
}