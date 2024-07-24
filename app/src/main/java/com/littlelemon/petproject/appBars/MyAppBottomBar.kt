package com.littlelemon.petproject.appBars

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun MyAppBottomBar(navController: NavController){
    BottomNavigation(
        modifier = Modifier
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Feed Icon") },
            selected = false,
            onClick = { navController.navigate("feed") }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.DateRange, contentDescription = "Archive Icon") },
            selected = false,
            onClick = { navController.navigate("archive") }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.AddCircle, contentDescription = "New workout") },
            selected = false,
            onClick = { navController.navigate("workout") }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Personal page") },
            selected = false,
            onClick = { navController.navigate("personalPage") }
        )
    }
}