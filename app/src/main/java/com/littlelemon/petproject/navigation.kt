package com.littlelemon.petproject

sealed class Screen(val route: String){
    object SignIn : Screen("sign_in")
    object SignUp : Screen("sign_up")
}