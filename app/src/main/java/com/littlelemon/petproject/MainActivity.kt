package com.littlelemon.petproject

import SignInScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @Composable
    fun MyApp() {
        var showSignInScreen by remember { mutableStateOf(true) }

        if (showSignInScreen) {
            SignInScreen(
                onSignIn = { email, password ->
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign-in successful
                            } else {
                                // Sign-in failed
                            }
                        }
                },
                onNavigateToSignUp = {
                    showSignInScreen = false
                }
            )
        } else {
            SignUpScreen(
                onSignUp = { email, password ->
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign-up successful
                            } else {
                                // Sign-up failed
                            }
                        }
                },
                onNavigateToSignIn = {
                    showSignInScreen = true
                }
            )
        }
    }
}
