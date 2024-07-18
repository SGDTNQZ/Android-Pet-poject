package com.littlelemon.petproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.littlelemon.petproject.screens.SignInScreen
import com.littlelemon.petproject.screens.SignUpScreen
import com.littlelemon.petproject.viewModels.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "signIn") {
        composable("signIn") { SignInScreen(navController) }
        composable("signUp") { SignUpScreen() }
    }
}

@Composable
fun SignInScreen(navController: NavHostController) {
    val viewModel: UserViewModel = viewModel()
    SignInScreen(viewModel) {
        navController.navigate("signUp")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
