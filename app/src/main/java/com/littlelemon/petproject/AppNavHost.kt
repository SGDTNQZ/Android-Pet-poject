package com.littlelemon.petproject.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.littlelemon.petproject.ui.screens.SignInScreen
import com.littlelemon.petproject.ui.screens.SignUpScreen
import com.littlelemon.petproject.ui.screens.HomeScreen
import com.littlelemon.petproject.AuthViewModel

@Composable
fun AppNavHost(navController: NavHostController, authViewModel: AuthViewModel) {
    NavHost(navController, startDestination = "sign_in") {
        composable("sign_in") {
            SignInScreen(
                onSignIn = { email, password ->
                    authViewModel.signIn(email, password, {
                        navController.navigate("home") {
                            popUpTo("sign_in") { inclusive = true }
                        }
                    }, {
                        // Handle error
                    })
                },
                onNavigateToSignUp = {
                    navController.navigate("sign_up")
                }
            )
        }
        composable("sign_up") {
            SignUpScreen(
                onSignUp = { email, password ->
                    authViewModel.signUp(email, password, {
                        navController.navigate("home") {
                            popUpTo("sign_up") { inclusive = true }
                        }
                    }, {
                        // Handle error
                    })
                },
                onNavigateToSignIn = {
                    navController.popBackStack()
                }
            )
        }
        composable("home") {
            HomeScreen()
        }
    }
}
