package com.littlelemon.petproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.littlelemon.petproject.navigation.AppNavigation
import com.littlelemon.petproject.navigation.Screen
import com.littlelemon.petproject.screens.FeedScreen
import com.littlelemon.petproject.screens.SignInScreen
import com.littlelemon.petproject.screens.SignUpScreen
import com.littlelemon.petproject.screens.WorkoutScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        FirebaseApp.initializeApp(this)
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppNavigation()
}
