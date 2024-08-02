package com.littlelemon.petproject.screens

import android.widget.Toast
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
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.petproject.navigation.Screen
import com.littlelemon.petproject.viewModels.AuthState
import com.littlelemon.petproject.viewModels.UserViewModel


@Composable
fun SignInScreen(navController: NavController, userViewModel: UserViewModel) {
    var email by  remember {
        mutableStateOf("")
    }
    var password by  remember {
        mutableStateOf("")
    }
    val authState = userViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("feed")
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column (
        modifier = Modifier
        .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)
                .background(color = Color.White),
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
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = email,
                onValueChange = {email = it},
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth(),
                placeholder = {
                    Text(text = "example@email.com")
                }
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Password",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = password,
                onValueChange = {password = it},
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
                    userViewModel.signIn(email, password)
                },
                enabled = authState.value != AuthState.Loading,
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

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview(){
    SignInScreen(navController = rememberNavController(), userViewModel = UserViewModel() )
}