package com.littlelemon.petproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.littlelemon.petproject.appBars.MyAppBottomBar
import com.littlelemon.petproject.appBars.MyAppTopBar

@Composable
fun WorkoutScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        ) {

        MyAppTopBar(navController)

        WorkoutHeader()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Add content here
            WorkoutItem()
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = CircleShape,
                backgroundColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
                modifier = Modifier
                    .padding(16.dp)) {
                Icon(
                    Icons.Default.AddCircle,
                    contentDescription = "Add button",
                    modifier = Modifier
                        .size(56.dp))
            }
        }
        MyAppBottomBar(navController)
    }
}


@Composable
fun WorkoutHeader(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Exercise name",
            fontSize = 20.sp,
        )
        Divider(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp),
        )
        Text(
            text = "Weight",
            fontSize = 20.sp,
        )
        Divider(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp),
        )
        Text(
            text = "Reps",
            fontSize = 20.sp,
        )
        Divider(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp),
        )
        Text(
            text = "Set",
            fontSize = 20.sp,
        )
    }
}


@Composable
fun WorkoutItem(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Column ( modifier = Modifier.weight(1f)) {
            Text(
                text = "Created at HH:mm:ss",
                fontSize = 12.sp,
                color = Color.LightGray
            )
            Row (
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Text(
                    text = "Exercise name",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Divider(
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp),
                    )
                Text(
                    text = "Weight",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Divider(
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp),
                )
                Text(
                    text = "Reps",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Divider(
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp),
                )
                Text(
                    text = "Set",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }

        }

    }
}
