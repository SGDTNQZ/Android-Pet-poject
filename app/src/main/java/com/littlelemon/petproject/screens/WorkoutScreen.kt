package com.littlelemon.petproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.petproject.appBars.MyAppBottomBar
import com.littlelemon.petproject.appBars.MyAppTopBar
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun WorkoutScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize(),) {

        MyAppTopBar(navController)

        Column(modifier = Modifier
            .fillMaxSize()
            .weight(1F),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Add content here

            WorkoutItem()

        }

        Row (modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){

            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.AddCircle,
                    contentDescription = "Add",
                    modifier = Modifier.size(100.dp))
            }
        }
        MyAppBottomBar(navController)
    }
}

@Composable
fun WorkoutItem(){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(MaterialTheme.colorScheme.primary)
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Column ( modifier = Modifier.weight(1f)) {
            Text(text = "Created at HH:mm:ss",
                fontSize = 12.sp,
                color = Color.LightGray)
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly){
                Text(
                    text = "Exercise name",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text(
                    text = "Weight",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text(
                    text = "Reps",
                    fontSize = 20.sp,
                    color = Color.White
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
