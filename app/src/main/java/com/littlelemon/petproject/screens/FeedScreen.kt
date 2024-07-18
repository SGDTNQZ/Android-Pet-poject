package com.littlelemon.petproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun feedScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)) {

        TopAppBar {
            Box(modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                
            )
            {
                Text(text = "Feed",
                    fontSize = 20.sp,
                    )
            }
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings Icon",
                modifier = Modifier
                    .clickable { /* Handle click */ }
                    .align(Alignment.CenterVertically),
            )
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .weight(1F),
        ) {
            // Add content here
        }

        BottomNavigation(
            modifier = Modifier
        ) {
            BottomNavigationItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Feed Icon") },
                selected = true,
                onClick = { /* Handle click */ }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Default.DateRange, contentDescription = "Archive Icon") },
                selected = false,
                onClick = { /* Handle click */ }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Default.AddCircle, contentDescription = "New workout") },
                selected = false,
                onClick = { /* Handle click */ }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Default.Person, contentDescription = "Personal page") },
                selected = false,
                onClick = { /* Handle click */ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun feedScreenPreview(){
    feedScreen()
}
