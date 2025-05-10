//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.ArrowDropDown
//import androidx.compose.material.icons.filled.DateRange
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Share
//import androidx.compose.material3.*
//import androidx.compose.material3.Icon
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.tooling.preview.Preview
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ShareJournalScreen() {
//    // Use your custom font family if you have one
//    val titleFont = FontFamily.Default
//
//    var email by remember { mutableStateOf(TextFieldValue("edilawit@gmail.com")) }
//    var expanded by remember { mutableStateOf(false) }
//    var selectedPermission by remember { mutableStateOf("Can view") }
//    val permissions = listOf("Can view", "Can edit")
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFFAF6F6))
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 24.dp, vertical = 20.dp)
//        ) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                IconButton(onClick = { /* handle back */ }) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = "Back",
//                        tint = Color.Black
//                    )
//                }
//                Spacer(modifier = Modifier.width(8.dp))
//                Text(
//                    "Wilowachn",
//                    style = TextStyle(
//                        fontFamily = titleFont,
//                        fontSize = 36.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Black
//                    ),
//                    modifier = Modifier.padding(top = 8.dp)
//                )
//            }
//            Spacer(modifier = Modifier.height(32.dp))
//            Text(
//                "Share Journal",
//                fontWeight = FontWeight.Bold,
//                fontSize = 24.sp,
//                color = Color.Black
//            )
//            Spacer(modifier = Modifier.height(24.dp))
//            Text(
//                "Share with",
//                fontWeight = FontWeight.Medium,
//                fontSize = 16.sp,
//                color = Color(0xFF6B6767)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            OutlinedTextField(
//                value = email,
//                onValueChange = { email = it },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp),
//                singleLine = true,
//                shape = RoundedCornerShape(8.dp)
//            )
//            Spacer(modifier = Modifier.height(24.dp))
//            Text(
//                "permissions",
//                fontWeight = FontWeight.Bold,
//                fontSize = 18.sp,
//                color = Color.Black
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Box {
//                TextButton(
//                    onClick = { expanded = true },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(48.dp),
//                    shape = RoundedCornerShape(8.dp),
//                    colors = ButtonDefaults.textButtonColors(
//
//                        containerColor = Color.Transparent,
//                        contentColor = Color.Black
//                    )
//                ) {
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(selectedPermission, color = Color.Black)
//                        Icon(
//                            imageVector = Icons.Filled.ArrowDropDown,
//                            contentDescription = null,
//                            tint = Color.Black
//                        )
//                    }
//                }
//                DropdownMenu(
//                    expanded = expanded,
//                    onDismissRequest = { expanded = false }
//                ) {
//                    permissions.forEach { permission ->
//                        DropdownMenuItem(
//                            text = { Text(permission) },
//                            onClick = {
//                                selectedPermission = permission
//                                expanded = false
//                            }
//                        )
//                    }
//                }
//            }
//            Spacer(modifier = Modifier.height(36.dp))
//            Button(
//                onClick = { /* handle share */ },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A11F9)),
//                shape = RoundedCornerShape(12.dp)
//            ) {
//                Text("Share", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
//            }
//        }
//        // Bottom Navigation Bar
//        NavigationBar(
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .fillMaxWidth(),
//            containerColor = Color(0xE0E7E1E1)
//        ) {
//            NavigationBarItem(
//                selected = false,
//                onClick = { /*TODO*/ },
//                icon = { Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.Black) }
//            )
//            NavigationBarItem(
//                selected = false,
//                onClick = { /*TODO*/ },
//                icon = { Icon(Icons.Filled.Edit, contentDescription = "Edit", tint = Color.Black) }
//            )
//            NavigationBarItem(
//                selected = false,
//                onClick = { /*TODO*/ },
//                icon = { Icon(Icons.Filled.DateRange, contentDescription = "Table", tint = Color.Black) }
//            )
//            NavigationBarItem(
//                selected = false,
//                onClick = { /*TODO*/ },
//                icon = { Icon(Icons.Filled.Share, contentDescription = "Share", tint = Color.Black) }
//            )
//        }
//    }
//}
//
//


package com.example.wilowachin.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShareJournalScreen() {
    var journalId by remember { mutableStateOf(TextFieldValue("")) }
    var recipientEmail by remember { mutableStateOf(TextFieldValue("")) }
    var shareStatus by remember { mutableStateOf<String?>(null) } // Track share status

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Share Journal", color = Color.White) },
//                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF6200EE))

            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Blue,
                titleContentColor = Color.White,
                navigationIconContentColor = Color.White,
                actionIconContentColor = Color.White
                // You can customize other colors as well
            )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = journalId,
                onValueChange = { journalId = it },
                label = { Text("Journal ID") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = recipientEmail,
                onValueChange = { recipientEmail = it },
                label = { Text("Recipient Email") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    // Simulate sharing logic
                    val id = journalId.text.toIntOrNull()
                    val email = recipientEmail.text
                    if (id != null && email.isNotBlank()) {
                        // In a real app, you'd send this data to a backend
                        shareStatus = "Journal $id shared with $email"
                    } else {
                        shareStatus = "Invalid input. Please enter valid Journal ID and Email."
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Share Journal")
            }
            Spacer(modifier = Modifier.height(16.dp))
            if (shareStatus != null) {
                Text(text = shareStatus!!)
            }
        }
    }
}
