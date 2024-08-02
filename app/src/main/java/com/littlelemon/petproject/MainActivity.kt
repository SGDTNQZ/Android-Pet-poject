package com.littlelemon.petproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.google.firebase.FirebaseApp
import com.littlelemon.petproject.navigation.AppNavigation
import com.littlelemon.petproject.viewModels.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        FirebaseApp.initializeApp(this)
        super.onCreate(savedInstanceState)
        val userViewModel: UserViewModel by viewModels()
        setContent {
            AppNavigation(userViewModel)
        }
    }
}
