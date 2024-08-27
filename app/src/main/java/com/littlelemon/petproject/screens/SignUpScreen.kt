package com.littlelemon.petproject.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.petproject.viewModels.AuthState
import com.littlelemon.petproject.viewModels.UserViewModel


@Composable
fun SignUpScreen(navController: NavController, userViewModel: UserViewModel){

    var name by  remember {
        mutableStateOf("")
    }
    var weight by remember {
        mutableFloatStateOf(0f)
    }
    var height by remember {
        mutableFloatStateOf(0f)
    }
    var email by  remember {
        mutableStateOf("")
    }
    var password by  remember {
        mutableStateOf("")
    }
    var repeatPassword by remember {
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
    ) {
        IconButton(onClick = { navController.navigate("sign_in")}) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
//            Name field
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Name",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = name,
                onValueChange = { name = it },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = { Text(text = "John Doe", fontSize = 15.sp)}
            )

//            Weight field
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Weight in kg",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = weight.toString(),
                onValueChange = { weight = it.toFloatOrNull() ?: 0f },
                modifier = Modifier
                    .fillMaxWidth(),
            )

//            Height field
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Height in cm",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = height.toString(),
                onValueChange = { height = it.toFloatOrNull() ?: 0f },
                modifier = Modifier
                    .fillMaxWidth(),
            )

//            Email field
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Email",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = { Text(text = "example@email.com", fontSize = 15.sp)}
            )

//            Password field
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Password",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = password,
                onValueChange = {password = it},
                modifier = Modifier
                    .fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation())

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Repeat your password",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = repeatPassword,
                onValueChange = {repeatPassword = it},
                modifier = Modifier
                    .fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation())


            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                userViewModel.signUp(email, password)
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),) {
                Text(text = "Sign Up", fontSize = 20.sp)
            }

        }
    }
}
