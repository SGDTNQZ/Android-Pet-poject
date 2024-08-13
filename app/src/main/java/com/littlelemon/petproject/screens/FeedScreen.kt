package com.littlelemon.petproject.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.petproject.appBars.MyAppBottomBar
import com.littlelemon.petproject.appBars.MyAppTopBar
import com.littlelemon.petproject.viewModels.UserViewModel

@Composable
fun FeedScreen(navController: NavController, userViewModel: UserViewModel){

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
