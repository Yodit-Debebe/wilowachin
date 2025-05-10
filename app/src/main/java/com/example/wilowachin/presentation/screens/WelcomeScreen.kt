////package com.example.wilowachin.presentation.screens
////
////
////import androidx.compose.foundation.BorderStroke
////import androidx.compose.foundation.layout.Arrangement
////import androidx.compose.foundation.layout.Column
////import androidx.compose.foundation.layout.Spacer
////import androidx.compose.foundation.layout.fillMaxSize
////import androidx.compose.foundation.layout.height
////import androidx.compose.foundation.layout.padding
////import androidx.compose.foundation.layout.width
////import androidx.compose.foundation.shape.RoundedCornerShape
////import androidx.compose.material.icons.Icons
////import androidx.compose.material.icons.filled.Edit
////import androidx.compose.material.icons.filled.Share
////import androidx.compose.material3.Button
////import androidx.compose.material3.ButtonDefaults
////import androidx.compose.material3.Icon
////import androidx.compose.material3.Surface
////import androidx.compose.material3.Text
////import androidx.compose.runtime.Composable
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.graphics.Color
////import androidx.compose.ui.text.font.FontWeight
////import androidx.compose.ui.unit.dp
////import androidx.compose.ui.unit.sp
////import androidx.navigation.NavHostController
////
////@Composable
////fun WelcomeScreen(navController: NavHostController) {
////    Surface(
////        modifier = Modifier.fillMaxSize(),
////        color = Color(0xFFF5F5F5) // Light background color
////    ) {
////        Column(
////            modifier = Modifier
////                .fillMaxSize()
////                .padding(16.dp),
////            horizontalAlignment = Alignment.CenterHorizontally,
////            verticalArrangement = Arrangement.Center
////        ) {
////            Text(
////                text = "Welcome to\nWilowachn!",
////                fontSize = 32.sp,
////                fontWeight = FontWeight.Bold,
////                color = Color.Black,
////                modifier = Modifier.padding(bottom = 80.dp),
////                lineHeight = 30.sp // Optional: Adjust line height for better spacing
////            )
////
////            Button(
////                onClick = { navController.navigate("myjournals") },
////                shape = RoundedCornerShape(8.dp),
////                border = BorderStroke(1.dp, Color.Blue), // Blue border
////                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5F5)), // Match background color
////                modifier = Modifier
////                    .width(300.dp) // Set a specific width
////                    .height(80.dp)
////                    .padding(bottom = 20.dp)
////            ) {
////                Icon(imageVector = Icons.Filled.Edit, contentDescription = "My Journals", tint = Color.Black)
////                Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text
////                Text(text = "My Journals", color = Color.Black, )
////            }
////            Spacer(modifier = Modifier.height(15.dp))
////
////            Button(
////                onClick = {  navController.navigate("SharedJournalPage") },
////                shape = RoundedCornerShape(8.dp),
////                border = BorderStroke(1.dp, Color.Blue), // Blue border
////                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5F5)), // Match background color
////                modifier = Modifier
////                    .width(300.dp) // Set a specific width
////                    .height(80.dp)
////                    .padding(bottom = 20.dp)
////            ) {
////                Icon(imageVector = Icons.Filled.Share, contentDescription = "Shared with me", tint = Color.Black)
////                Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text
////                Text(text = "Shared with me", color = Color.Black)
////            }
////        }
////    }
////}
//
//


// (Code for WelcomeScreen.kt as you provided earlier)
package com.example.wilowachin.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF5F5F5) // Light background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome to\nWilowachn!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 80.dp),
                lineHeight = 30.sp // Optional: Adjust line height for better spacing
            )

            Button(
                onClick = { navController.navigate("myjournals") },
                shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color.Blue), // Blue border
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5F5)), // Match background color
                modifier = Modifier
                    .width(300.dp) // Set a specific width
                    .height(80.dp)
                    .padding(bottom = 20.dp)
            ) {
                Icon(imageVector = Icons.Filled.Edit, contentDescription = "My Journals", tint = Color.Black)
                Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text
                Text(text = "My Journals", color = Color.Black, )
            }
            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {  navController.navigate("sharedJournalPage") },
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.Blue), // Blue border
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5F5)), // Match background color
                modifier = Modifier
                    .width(300.dp) // Set a specific width
                    .height(80.dp)
                    .padding(bottom = 20.dp)
            ) {
                Icon(imageVector = Icons.Filled.Share, contentDescription = "Shared with me", tint = Color.Black)
                Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text
                Text(text = "Shared with me", color = Color.Black)
            }
        }
    }
}