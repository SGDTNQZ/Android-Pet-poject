package com.littlelemon.petproject.appBars

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MyAppTopBar(navController: NavController ){
    TopAppBar {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1F),
        )
        {
            Text(text = "",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Center),
            )
        }
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Settings Icon",
            modifier = Modifier
                .weight(0.1F)
                .clickable { /* Handle click */ }
                .align(Alignment.CenterVertically),
        )
    }
}