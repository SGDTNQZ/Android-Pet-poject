package com.littlelemon.petproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.petproject.navigation.Screen


@Composable
//fun SignUpScreen(viewModel: UserViewModel = viewModel(), navController: NavController){
fun SignUpScreen( navController: NavController){

//    val email by viewModel.email.collectAsState()
//    val password by viewModel.password.collectAsState()
//    val confirmPassword by viewModel.confirmPassword.collectAsState()
//    val name by viewModel.name.collectAsState()
//    val age by viewModel.age.collectAsState()
//    val weight by viewModel.weight.collectAsState()
//    val height by viewModel.height.collectAsState()
//    val signUpStatus by viewModel.signUpStatus.collectAsState()

    val email : String = ""
    val password : String = ""
    val confirmPassword : String = ""
    val name : String = ""
    val age : String = ""
    val weight : String = ""
    val height : String = ""
    val signUpStatus : String = ""

    Column (
        modifier = Modifier
            .background(color = Color.Black)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)
                .background(color = Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(text = "Email",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = email,
                onValueChange = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                placeholder = { Text(text = "example@email.com", fontSize = 15.sp)}
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Name",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = name,
                onValueChange = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                placeholder =   { Text(text = "John Doe", fontSize = 15.sp)} )

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Age",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = age,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                placeholder = { Text(text = "23", fontSize = 15.sp)})

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Weight (in Kgs)",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = weight,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                placeholder = { Text(text = "95", fontSize = 15.sp)})

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Height (in cm)",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = height,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                placeholder = { Text(text = "185", fontSize = 15.sp)})

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Password",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = password,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                visualTransformation = PasswordVisualTransformation())

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Repeat your password",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = confirmPassword,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                visualTransformation = PasswordVisualTransformation())


            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
//                viewModel.signUp(email, password)
                navController.navigate(Screen.Feed.route)
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),) {
                Text(text = "Sign Up", fontSize = 20.sp)
            }

            if (signUpStatus.isNotEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = signUpStatus, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview(){
    SignUpScreen(navController = rememberNavController())
}