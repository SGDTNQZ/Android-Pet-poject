package com.littlelemon.petproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.littlelemon.petproject.ui.Theme
import com.littlelemon.petproject.ui.AppNavHost
import com.littlelemon.petproject.AuthViewModel

class MainActivity : ComponentActivity() {
    private val auth = Firebase.auth
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                MyApp(authViewModel)
            }
        }
    }

    @Composable
    fun MyApp(authViewModel: AuthViewModel) {
        val navController = rememberNavController()
        AppNavHost(navController = navController, authViewModel = authViewModel)
    }
}
