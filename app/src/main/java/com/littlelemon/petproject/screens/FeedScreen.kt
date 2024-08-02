package com.littlelemon.petproject.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.petproject.appBars.MyAppBottomBar
import com.littlelemon.petproject.appBars.MyAppTopBar
import com.littlelemon.petproject.viewModels.AuthState
import com.littlelemon.petproject.viewModels.UserViewModel

@Composable
fun FeedScreen(navController: NavController, userViewModel: UserViewModel){
    val authState = userViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("feed")
            else -> Unit
        }
    }

    Column(modifier = Modifier
        .fillMaxSize(),) {

        MyAppTopBar(navController)

        Column(modifier = Modifier
            .fillMaxSize()
            .weight(1F),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Add content here

            Text( text = "Feed")
        }

        MyAppBottomBar(navController)
    }

}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview(){
    FeedScreen(navController = rememberNavController(), userViewModel = UserViewModel())
}
