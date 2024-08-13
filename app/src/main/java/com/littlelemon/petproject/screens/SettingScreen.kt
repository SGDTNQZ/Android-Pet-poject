package com.littlelemon.petproject.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.littlelemon.petproject.viewModels.AuthState
import com.littlelemon.petproject.viewModels.UserViewModel

@Composable
fun SettingScreen(navController: NavController, userViewModel: UserViewModel){
    val authState = userViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Unauthenticated-> navController.navigate("sign_in")
            else -> Unit
        }
    }
    Column (Modifier.padding(10.dp)){
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .clickable { navController.navigate("feed") })
        Column  (modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,) {

            Button(onClick = { userViewModel.signOut() }) {
                Text(text = "Sign Out",
                    fontSize = 20.sp,)
            }
        }
    }

}


