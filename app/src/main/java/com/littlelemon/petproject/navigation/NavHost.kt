package com.littlelemon.petproject.navigation

sealed class Screen(val route: String){
    object SignIn : Screen("sign_in")
    object SignUp : Screen("sign_up")
    object Feed : Screen("feed")
    object WorkOut : Screen("workout")
    object PersonalPage : Screen("personalPage")
    object Archive : Screen("archive")
}