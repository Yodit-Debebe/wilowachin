//
//package com.example.wilowachin.presentation.screens
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//@Composable
//fun MyJournalsScreen(navController: NavController) { // Add NavController as a parameter
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
//            Button(
//                onClick = { /* Handle New Journal click */ },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 16.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0000FF))
//            ) {
//                Text(text = "+   New Journal", color = Color.White)
//            }
//            Text(
//                text = "My Journals",
//                fontSize = 32.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(start = 8.dp) // Add some space between the icon and text
//            )
//            Spacer(modifier = Modifier.height(15.dp))
//
//
//            // Add Journal Items
//            JournalItem(title = "Weekend Trip", date = "April 22, 2024", description = "Had an amazing weekend....")
//            JournalItem(title = "Morning Reflection", date = "April 20, 2024", description = "This morning I spent some time thinking....")
//            JournalItem(title = "Book Notes", date = "April 19, 2024", description = "Thoughts on the novel I’ve been reading....")
//        }
//    }
//}
//
//@Composable
//fun JournalItem(title: String, date: String, description: String) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = 16.dp)
//            .shadow(4.dp, shape = RoundedCornerShape(8.dp)), // Use shadow instead of elevation
//        shape = RoundedCornerShape(8.dp),
//        border = BorderStroke(1.dp, Color.LightGray)
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth()
//        ) {
//            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(text = date, fontSize = 14.sp, color = Color.Gray)
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = description, fontSize = 14.sp, color = Color.Black) // Add description
//            Spacer(modifier = Modifier.height(8.dp))
//            // Optionally, add an edit icon or button here
//            Text(
//                text = "✎", // Placeholder for edit icon
//                modifier = Modifier.align(Alignment.End)
//            )
//        }
//    }
//}



//
//// (Code for Myjournals.kt as you provided earlier, renamed to MyJournalsScreen for consistency)
//package com.example.wilowachn.ui.screens
//
//import android.app.Application
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.wilowachin.viewmodel.MyJournalsViewModel
//import androidx.navigation.NavController
//
//@Composable
//fun MyJournalsScreen(navController: NavController) { // Add NavController as a parameter
//    // Get the Application context.
//    val context = LocalContext.current
//    val application = context.applicationContext as Application  // Cast to Application
//    // Create a ViewModel instance.
//    val myJournalsViewModel: MyJournalsViewModel = remember {
//        MyJournalsViewModel(application)
//    }
//
//    // Observe the journal list using collectAsState().
//    val journals by myJournalsViewModel.allJournals.collectAsState(initial = emptyList())
//
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
//            Button(
//                onClick = {
//                    // Navigate to the journal editor screen.  Pass 0 for a new journal.
//                    navController.navigate("journalEditor/0")
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 16.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0000FF))
//            ) {
//                Text(text = "+   New Journal", color = Color.White)
//            }
//            Text(
//                text = "My Journals",
//                fontSize = 32.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(start = 8.dp) // Add some space between the icon and text
//            )
//            Spacer(modifier = Modifier.height(15.dp))
//
//            // Display the list of journals.
//            if (journals.isEmpty()) {
//                Text(text = "No journals yet. Create one!")
//            } else {
//                journals.forEach { journal ->
//                    JournalItem(
//                        journal = journal,
//                        onDelete = { myJournalsViewModel.deleteJournalById(journal.id) },
//                        onEdit = { navController.navigate("journalEditor/${journal.id}") }
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun JournalItem(journal: com.example.wilowachin.data.model.Journal, onDelete: () -> Unit, onEdit: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = 16.dp)
//            .shadow(4.dp, shape = RoundedCornerShape(8.dp)), // Use shadow instead of elevation
//        shape = RoundedCornerShape(8.dp),
//        border = BorderStroke(1.dp, Color.LightGray)
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth()
//        ) {
//            Text(text = journal.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = java.text.SimpleDateFormat("MMM dd, yyyy", java.util.Locale.getDefault()).format(
//                    java.util.Date(journal.createdAt)
//                ),
//                fontSize = 14.sp,
//                color = Color.Gray
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = journal.content, fontSize = 14.sp, color = Color.Black, maxLines = 2) // Add description
//            Spacer(modifier = Modifier.height(8.dp))
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.End
//            ) {
//                Text(
//                    text = "✎", // Placeholder for edit icon
//                    modifier = Modifier.clickable { onEdit() }
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Text(
//                    text = "X",
//                    modifier = Modifier.clickable { onDelete() },
//                    color = Color.Red
//                )
//            }
//        }
//    }
//}


//
//package com.example.wilowachin.presentation.screens
//
//import android.app.Application
//import android.util.Log
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.example.wilowachin.viewmodel.MyJournalsViewModel
//import androidx.compose.runtime.key
//
//@Composable
//fun MyJournalsScreen(navController: NavController) {
//    Log.d("MyJournalScreen", "MyJournalScreenComposable is being called")
//    // Get the Application context.
//    val context = LocalContext.current
//    val application = context.applicationContext as Application
//    // Create a ViewModel instance.
//    val myJournalsViewModel: MyJournalsViewModel = remember {
//        MyJournalsViewModel(application)
//    }
//
//    // Observe the journal list using collectAsState().
//    val journals by myJournalsViewModel.allJournals.collectAsState(initial = emptyList())
//
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
//            Button(
//                onClick = {
//                    // Navigate to the journal editor screen.  Pass 0 for a new journal.
//                    navController.navigate("journalEditor/0")
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 16.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0000FF))
//            ) {
//                Text(text = "+   New Journal", color = Color.White)
//            }
//            Text(
//                text = "My Journals",
//                fontSize = 32.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(start = 8.dp) // Add some space between the icon and text
//            )
//            Spacer(modifier = Modifier.height(15.dp))
//
//            // Display the list of journals.
//            if (journals.isEmpty()) {
//                Text(text = "No journals yet. Create one!")
//            } else {
//                LazyColumn { // Use LazyColumn for better performance with potentially large lists
//                    items(journals) { journal ->
//                        key(journal.id) {  // Use key for better item re-composition
//                            JournalItem(
//                                journal = journal,
//                                onDelete = { myJournalsViewModel.deleteJournalById(journal.id) },
//                                onEdit = { navController.navigate("journalEditor/${journal.id}") }
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun JournalItem(journal: com.example.wilowachin.data.model.Journal, onDelete: () -> Unit, onEdit: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = 16.dp)
//            .shadow(4.dp, shape = RoundedCornerShape(8.dp)), // Use shadow instead of elevation
//        shape = RoundedCornerShape(8.dp),
//        border = BorderStroke(1.dp, Color.LightGray)
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth()
//        ) {
//            Text(text = journal.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(
//                text = java.text.SimpleDateFormat("MMM dd, yyyy", java.util.Locale.getDefault()).format(
//                    java.util.Date(journal.createdAt)
//                ),
//                fontSize = 14.sp,
//                color = Color.Gray
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = journal.content, fontSize = 14.sp, color = Color.Black, maxLines = 2) // Add description
//            Spacer(modifier = Modifier.height(8.dp))
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.End
//            ) {
//                Text(
//                    text = "✎", // Placeholder for edit icon
//                    modifier = Modifier.clickable { onEdit() }
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Text(
//                    text = "X",
//                    modifier = Modifier.clickable { onDelete() },
//                    color = Color.Red
//                )
//            }
//        }
//    }
//}




package com.example.wilowachin.presentation.screens

import android.app.Application
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.key
import androidx.navigation.NavHostController
import com.example.wilowachn.ui.viewmodels.MyJournalsViewModel

@Composable
fun MyJournalsScreen(navController: NavHostController) {
    Log.d("MyJournalsScreen", "MyJournalsScreen Composable is being called!")
    // Get the Application context.
    val context = LocalContext.current
    val application = context.applicationContext as Application
    // Create a ViewModel instance.
    val myJournalsViewModel: MyJournalsViewModel = remember {
        MyJournalsViewModel(application)
    }

    // Observe the journal list using collectAsState().
    val journals by myJournalsViewModel.allJournals.collectAsState(initial = emptyList())

    Log.d("MyJournalsScreen", "Number of journals: ${journals.size}")

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF5F5F5) // Light background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Back Button and Title
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                IconButton(onClick = {
                    Log.d("MyJournalsScreen", "Back button clicked")
                    navController.popBackStack()
                }) { // Handle back navigation
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }
                Text(
                    text = "Wilowachn",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            Button(
                onClick = {
                    Log.d("MyJournalsScreen", "New Journal button clicked")
                    // Navigate to the journal editor screen.  Pass 0 for a new journal.
                    navController.navigate("journalEditor/0")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0000FF))
            ) {
                Text(text = "+   New Journal", color = Color.White)
            }
            Text(
                text = "My Journals",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp) // Add some space between the icon and text
            )
            Spacer(modifier = Modifier.height(15.dp))
            // Display the list of journals.
            if (journals.isEmpty()) {
                Log.d("MyJournalsScreen", "No journals to display")
                Text(text = "No journals yet. Create one!")
            } else {
                Log.d("MyJournalsScreen", "Displaying journals")
                LazyColumn { // Use LazyColumn for better performance with potentially large lists
                    items(journals) { journal ->
                        key(journal.id) {  // Use key for better item re-composition
                            JournalItem(
                                journal = journal,
                                onDelete = {
                                    Log.d("MyJournalsScreen", "Delete journal ${journal.id}")
                                    myJournalsViewModel.deleteJournalById(journal.id)
                                },
                                onEdit = {
                                    Log.d("MyJournalsScreen", "Edit journal ${journal.id}")
                                    navController.navigate("journalEditor/${journal.id}")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun JournalItem(journal: com.example.wilowachin.data.model.Journal, onDelete: () -> Unit, onEdit: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .shadow(4.dp, shape = RoundedCornerShape(8.dp)), // Use shadow instead of elevation
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = journal.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = java.text.SimpleDateFormat("MMM dd, yyyy", java.util.Locale.getDefault()).format(
                    java.util.Date(journal.createdAt)
                ),
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = journal.content, fontSize = 14.sp, color = Color.Black, maxLines = 2) // Add description
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "✎", // Placeholder for edit icon
                    modifier = Modifier.clickable { onEdit() }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "X",
                    modifier = Modifier.clickable { onDelete() },
                    color = Color.Red
                )
            }
        }
    }
}
