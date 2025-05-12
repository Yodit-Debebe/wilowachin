package com.example.mobileapp


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JournalEditorScreen(
    navController: NavController,
    onSave: () -> Unit = {},
    onDelete: () -> Unit = {},
    onBack: () -> Unit = {}
) {
    val bgColor = Color(0xFFF7F0EE)
    val purple = Color(0xFF4000F4)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF6F6))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(bgColor)
                .padding(24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Wilowachin",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Create Journal",
                fontWeight = FontWeight.Black,
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Title",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF555052),
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = "weekend trip",
                onValueChange = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(fontSize = 18.sp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Content",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF555052),
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = "Had an amazing weekend at the coast",
                onValueChange = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(fontSize = 16.sp)
            )

            Spacer(modifier = Modifier.height(36.dp))
            Button(
                onClick = onSave,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = purple),
                shape = RoundedCornerShape(14.dp),
                elevation = ButtonDefaults.buttonElevation(0.dp)
            ) {
                Text("Save", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = onDelete,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(14.dp),
                border = BorderStroke(1.dp, Color(0xFFDDDDDD)),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White)
            ) {
                Text("Delete", fontSize = 18.sp, color = Color.Black)
            }
        }

        // Bottom Navigation Bar
        NavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            containerColor = Color(0xE0E7E1E1)
        ) {
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate("welcome") },
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.Black) }
            )
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate("editor") },
                icon = { Icon(Icons.Filled.Edit, contentDescription = "Edit", tint = Color.Black) }
            )
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate("myjournals") },
                icon = { Icon(Icons.Filled.DateRange, contentDescription = "Table", tint = Color.Black) }
            )
            NavigationBarItem(
                selected = false,
                onClick = {navController.navigate("Sharing") },
                icon = { Icon(Icons.Filled.Share, contentDescription = "Share", tint = Color.Black) }
            )
        }
    }
}
