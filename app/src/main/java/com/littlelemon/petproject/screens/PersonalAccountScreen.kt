package com.littlelemon.petproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.petproject.appBars.MyAppBottomBar
import com.littlelemon.petproject.appBars.MyAppTopBar
import com.littlelemon.petproject.viewModels.AuthState
import com.littlelemon.petproject.viewModels.UserViewModel
import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.math.pow

@Composable
fun PersonalAccountScreen(navController: NavController, userViewModel: UserViewModel){

    val authState = userViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Unauthenticated-> navController.navigate("sign_in")
            else -> Unit
        }
    }

    val userList by userViewModel.userList.observeAsState(emptyList())


    val user = userList.firstOrNull()

    // Format the date before displaying it
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val formattedDate = user?.createdAt?.let { dateFormat.format(it) } ?: "N/A"

    // Calculate BMI
    val bmi = user?.let {
        if (it.height > 0) {
            it.weight / (it.height / 100).pow(2)
        } else {
            null
        }
    }

    Column(modifier = Modifier
        .fillMaxSize(),) {

        MyAppTopBar(navController)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1F)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
        ) {
//            Name field
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
                ){
                Text(
                    text = "Name: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = user?.name ?: "N/A",
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.size(10.dp))

//              Date field
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Created at: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = formattedDate,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
//            Sex field
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Sex: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = user?.sex ?: "N/A",
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.size(10.dp))

//            Weight field
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Weight in kg: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = "${user?.weight ?: "N/A"} kg",
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.size(10.dp))

//            Height field
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Height in cm: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = "${user?.weight ?: "N/A"} cm",
                    fontSize = 16.sp
                )
            }
            // BMI field
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "BMI: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = bmi?.let { String.format("%.1f", it) } ?: "N/A",
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.size(10.dp))


            Button(
                onClick = {
                    if (user != null){
                        userViewModel.deleteUser(user.id)
                        userViewModel.signOut()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Delete Account",
                    fontSize = 20.sp,
                    )
            }

        }

        MyAppBottomBar(navController)
    }

}
