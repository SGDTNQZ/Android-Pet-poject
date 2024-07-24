package com.littlelemon.petproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.petproject.navigation.Screen


@Composable
//fun SignInScreen(viewModel: UserViewModel = viewModel(), navController: NavHostController) {
fun SignInScreen( navController: NavHostController) {
//    val email by viewModel.email.collectAsState()
//    val password by viewModel.password.collectAsState()
//    val signInStatus by viewModel.signInStatus.collectAsState()

    val email: String = ""
    val password: String = ""
    val signInStatus: String = ""

    Column (
        modifier = Modifier
        .background(color = Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)
                .background(color = Color.Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = Icons.Outlined.ThumbUp,
                contentDescription = "Logo icon",
                modifier = Modifier
                    .size(150.dp)
                    .background(color = Color.White)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Login",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = email,
                onValueChange = {},
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth(),
                placeholder = {
                    Text(text = "Email")
                }
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Password",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = password,
                onValueChange = {},
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth(),
                placeholder = {
                    Text(text = "Password")
                },
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
//                    viewModel.signIn(email, password)
                    navController.navigate(Screen.Feed.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Sign In", fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { navController.navigate(Screen.SignUp.route) },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Sign Up", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Forgot password?",
                color = Color.Gray,
                modifier = Modifier.clickable {/*TODO*/ }
            )

            if (signInStatus.isNotEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = signInStatus, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen(navController = rememberNavController())
}
