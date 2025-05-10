//
//package com.example.wilowachin.presentation.screens
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.ArrowForward
//import androidx.compose.material3.Card
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//
//
//
//@Composable
//fun SharedJournalScreen (navController: NavController) { // Add NavController as a parameter
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = Color(0xFFF5F5F5) // Light background color
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.Top
//        ) {
//            // Back Button and Title
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(bottom = 16.dp)
//            ) {
//                IconButton(onClick = { navController.popBackStack() }) { // Handle back navigation
//                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
//                }
//                Text(
//                    text = "Wilowachn",
//                    fontSize = 32.sp,
//                    fontWeight = FontWeight.Bold,
//                )
//            }
//
//
//            Text(
//                text = "Shared With Me",
//                fontSize = 32.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(start = 8.dp) // Add some space between the icon and text
//            )
//            Spacer(modifier = Modifier.height(15.dp))
//
//
//            // Add Journal Items
//            SharedItem(title = "Daily Thoughts", date = "April 22, 2024", description = "Had an amazing weekend....")
//            SharedItem(title = "Travel Journal", date = "April 20, 2024", description = "This morning I spent some time thinking....")
//            SharedItem(title = "Research Idea", date = "April 19, 2024", description = "Thoughts on the novel I’ve been reading....")
//        }
//    }
//}
//
//@Composable
//fun SharedItem(title: String, date: String, description: String) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = 16.dp)
//            .shadow(4.dp, shape = RoundedCornerShape(8.dp)), // Use shadow instead of elevation
//        shape = RoundedCornerShape(8.dp),
//        border = BorderStroke(1.dp, Color.LightGray)
//    )
//    {
//
//
//        Row(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(
//                    text = title,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 24.sp // Looks like about 24sp in screenshot
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = date,
//                    fontSize = 16.sp, // Looks slightly bigger than 14sp
//                    color = Color.Black
//                )
//            }
//            Icon(
//                imageVector = Icons.Default.ArrowForward,
//                contentDescription = "Navigate",
//                tint = Color.Black,
//                modifier = Modifier.size(32.dp) // Bigger size for visibility
//            )
//        }
//    }
//}
//



package com.example.wilowachin.presentation.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wilowachin.viewmodel.SharedJournalsViewModel

@Composable
fun SharedJournalScreen(navController: NavController) {
    val context = LocalContext.current
    val application = context.applicationContext as Application
    val sharedJournalsViewModel: SharedJournalsViewModel = remember {
        SharedJournalsViewModel(application)
    }

    val sharedJournals by sharedJournalsViewModel.sharedJournals.collectAsState(initial = emptyList())

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF5F5F5)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }
                Text(
                    text = "Shared Journals",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            if (sharedJournals.isEmpty()) {
                Text(text = "No journals have been shared with you yet.")
            } else {
                sharedJournals.forEach { journal ->
                    // Display shared journal item.  You can reuse JournalItem or create a new one.
                    Text(text = "Title: ${journal.title}, Content: ${journal.content}")
                }
            }
        }
    }
}